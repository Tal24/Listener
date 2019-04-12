package com.tsts.listener.domain.show.newshow;

import com.tsts.listener.BaseIT;
import com.tsts.listener.TestUtils;
import com.tsts.listener.client.messaging.notification.NewShowListenerNotificationDTO;
import com.tsts.listener.client.messaging.notification.NotificationsChannels;
import com.tsts.listener.client.messaging.show.ShowChannels;
import com.tsts.listener.client.messaging.show.ShowDTO;
import com.tsts.listener.client.rest.listenerdetails.ListenerDTO;
import com.tsts.listener.domain.entity.*;
import com.tsts.listener.domain.listener.details.ListenerDetailsRepository;
import com.tsts.listener.domain.show.details.ShowDetailsRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class NewShowIT extends BaseIT {

    @Autowired
    private ShowChannels showChannels;

    @Autowired
    private NotificationsChannels notificationsChannels;

    @Autowired
    private ListenerDetailsRepository listenerDetailsRepository;

    @Autowired
    private MessageCollector messageCollector;

    @Autowired
    private ShowDetailsRepository showDetailsRepository;

    @Before
    public void setUp () {
        showDetailsRepository.deleteAll();
    }

    @Test
    public void shouldSaveShowDetailsAndSendNotificationsToListenersWhenNewShowEventReceived () throws Exception {
        // arrange
        UUID sportsListenerId = UUID.randomUUID();
        Listener sportsListener = new Listener(sportsListenerId, new Name("John"), new Name("Red"), new PhoneNumber("0505-999999"));
        sportsListener.addFavoriteCategory(Category.SPORTS);
        Listener newsListener = new Listener(UUID.randomUUID(), new Name("Ted"), new Name("Son"), new PhoneNumber("0505-111111"));
        newsListener.addFavoriteCategory(Category.NEWS);
        listenerDetailsRepository.saveAll(Arrays.asList(sportsListener, newsListener));

        Name newShowName = new Name("SportsCenter");
        ShowDTO newShowDTO = ShowDTO.builder(newShowName.get(), Category.SPORTS).listenersAllowedToCall(false).build();
        Message<ShowDTO> newShowEventMessage = MessageBuilder.withPayload(newShowDTO).build();

        Show expectedSavedShow = new Show(newShowName, Category.SPORTS, false);
        ListenerDTO sportsListenerDTO = ListenerDTO.builder(sportsListenerId.toString(), "John", "Red", "0505-999999").favoriteCategories(Collections.singletonList(Category.SPORTS)).build();

        // act
        showChannels.newShow().send(newShowEventMessage);

        // assert
        assertThat(showDetailsRepository.findById(newShowName)).isEqualTo(Optional.of(expectedSavedShow));
        NewShowListenerNotificationDTO expectedNotification = new NewShowListenerNotificationDTO(newShowDTO, Collections.singletonList(sportsListenerDTO));
        NewShowListenerNotificationDTO actualNotification = TestUtils.getMessagePayload(messageCollector, notificationsChannels.newShowNotificationToListeners(), NewShowListenerNotificationDTO.class);
        assertThat(actualNotification).isEqualTo(expectedNotification);
    }

}
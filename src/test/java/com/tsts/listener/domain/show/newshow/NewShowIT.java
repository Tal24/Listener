package com.tsts.listener.domain.show.newshow;

import com.tsts.listener.BaseIT;
import com.tsts.listener.TestUtils;
import com.tsts.listener.domain.entity.*;
import com.tsts.listener.domain.details.ListenerDetailsRepository;
import com.tsts.listener.domain.notification.NewShowListenerNotification;
import com.tsts.listener.client.rest.messaging.NotificationsChannels;
import com.tsts.listener.client.messaging.channel.ShowChannels;
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
        Listener sportsListener = new Listener(UUID.randomUUID(), new Name("John"), new Name("Red"), new PhoneNumber("0505-999999"));
        sportsListener.addFavoriteCategory(Category.SPORTS);
        Listener newsListener = new Listener(UUID.randomUUID(), new Name("Ted"), new Name("Son"), new PhoneNumber("0505-111111"));
        sportsListener.addFavoriteCategory(Category.NEWS);
        listenerDetailsRepository.saveAll(Arrays.asList(sportsListener, newsListener));

        Name newShowName = new Name("SportsCenter");
        Show newShow = new Show(newShowName, Category.SPORTS, false);
        Message<Show> newShowEventMessage = MessageBuilder.withPayload(newShow).build();

        // act
        showChannels.newShow().send(newShowEventMessage);

        // assert
        assertThat(showDetailsRepository.findById(newShowName)).isEqualTo(Optional.of(newShow));
        NewShowListenerNotification expectedNotification = new NewShowListenerNotification(newShow, Collections.singletonList(sportsListener));
        NewShowListenerNotification actualNotification = TestUtils.getMessagePayload(messageCollector, notificationsChannels.newShowNotificationToListeners(), NewShowListenerNotification.class);
        assertThat(actualNotification).isEqualTo(expectedNotification);
    }

}
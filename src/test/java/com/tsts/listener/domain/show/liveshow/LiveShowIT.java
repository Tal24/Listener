package com.tsts.listener.domain.show.liveshow;

import com.tsts.listener.BaseIT;
import com.tsts.listener.client.messaging.show.liveshow.LiveShowDTO;
import com.tsts.listener.domain.entity.Name;
import com.tsts.listener.client.messaging.show.ShowChannels;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class LiveShowIT extends BaseIT {

    @Autowired
    private ShowChannels showChannels;

    @Autowired
    private LiveShowRepository liveShowRepository;

    @Before
    public void setUp () {
        liveShowRepository.deleteAll();
    }

    @Test
    public void shouldSaveLiveShowWhenLiveShowEventReceived () {
        // arrange
        Name showName = new Name("SportsCenter");
        LiveShowDTO liveShowDTO = new LiveShowDTO(showName.get(), LocalDateTime.of(2020, 1, 1, 12, 0));
        Message<LiveShowDTO> liveShowMessage = MessageBuilder.withPayload(liveShowDTO).build();

        LiveShow expectedLiveShow = new LiveShow(showName, LocalDateTime.of(2020, 1, 1, 12, 0));

        // act
        showChannels.liveShow().send(liveShowMessage);

        // assert
        assertThat(liveShowRepository.findById(showName)).isEqualTo(Optional.of(expectedLiveShow));
    }
}

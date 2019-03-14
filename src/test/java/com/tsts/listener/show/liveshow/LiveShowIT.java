package com.tsts.listener.show.liveshow;

import com.tsts.listener.domain.Name;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LiveShowIT {

    @Autowired
    private LiveShowEvent liveShowEvent;

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
        LiveShow liveShow = new LiveShow(showName, LocalDateTime.of(2020, 1, 1, 12, 0));
        Message<LiveShow> liveShowMessage = MessageBuilder.withPayload(liveShow).build();

        // act
        liveShowEvent.liveShow().send(liveShowMessage);

        // assert
        assertThat(liveShowRepository.findById(showName)).isEqualTo(Optional.of(liveShow));
    }
}

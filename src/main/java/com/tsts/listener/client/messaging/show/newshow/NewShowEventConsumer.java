package com.tsts.listener.client.messaging.show.newshow;

import com.tsts.listener.domain.entity.Show;
import com.tsts.listener.domain.show.newshow.NewShowService;
import org.springframework.cloud.stream.annotation.StreamListener;

import javax.validation.Valid;

import static com.tsts.listener.client.messaging.channel.ShowChannels.NEW_SHOW;

public class NewShowEventConsumer {

    private final NewShowService newShowService;

    public NewShowEventConsumer (NewShowService newShowService) {
        this.newShowService = newShowService;
    }

    @StreamListener(NEW_SHOW)
    public void handleNewShowEvent (@Valid Show show) {
        newShowService.handleNewShowEvent(show);
    }
}

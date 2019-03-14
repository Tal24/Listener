package com.tsts.listener.show.newshow;

import com.tsts.listener.domain.Show;
import org.springframework.cloud.stream.annotation.StreamListener;

import javax.validation.Valid;

import static com.tsts.listener.show.newshow.NewShowEvent.NEW_SHOW;

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

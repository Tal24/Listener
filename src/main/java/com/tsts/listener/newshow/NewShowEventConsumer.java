package com.tsts.listener.newshow;

import org.springframework.cloud.stream.annotation.StreamListener;

import static com.tsts.listener.newshow.NewShowEvent.NEW_SHOW;

public class NewShowEventConsumer {

    private final NewShowService newShowService;

    public NewShowEventConsumer (NewShowService newShowService) {
        this.newShowService = newShowService;
    }

    @StreamListener(NEW_SHOW)
    public void handleNewShowEvent (Show show) {
        newShowService.handleNewShowEvent(show);
    }
}

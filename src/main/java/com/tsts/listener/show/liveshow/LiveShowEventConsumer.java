package com.tsts.listener.show.liveshow;

import org.springframework.cloud.stream.annotation.StreamListener;

import javax.validation.Valid;

import static com.tsts.listener.show.liveshow.LiveShowEvent.LIVE_SHOW;

public class LiveShowEventConsumer {

    private final LiveShowService liveShowService;

    public LiveShowEventConsumer (LiveShowService liveShowService) {
        this.liveShowService = liveShowService;
    }

    @StreamListener(LIVE_SHOW)
    public void handleLiveShowEvent (@Valid LiveShow show) {
        liveShowService.handleLiveShowEvent(show);
    }
}

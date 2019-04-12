package com.tsts.listener.client.messaging.show.liveshow;

import com.tsts.listener.domain.show.liveshow.LiveShow;
import com.tsts.listener.domain.show.liveshow.LiveShowService;
import org.springframework.cloud.stream.annotation.StreamListener;

import javax.validation.Valid;

import static com.tsts.listener.client.messaging.show.ShowChannels.LIVE_SHOW;

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

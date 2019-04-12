package com.tsts.listener.client.messaging.show.liveshow;

import com.tsts.listener.domain.show.liveshow.LiveShowService;
import org.springframework.cloud.stream.annotation.StreamListener;

import javax.validation.Valid;

import static com.tsts.listener.client.messaging.show.ShowChannels.LIVE_SHOW;

public class LiveShowEventConsumer {

    private final LiveShowService liveShowService;
    private final LiveShowMapper liveShowMapper;

    public LiveShowEventConsumer (LiveShowService liveShowService, LiveShowMapper liveShowMapper) {
        this.liveShowService = liveShowService;
        this.liveShowMapper = liveShowMapper;
    }

    @StreamListener(LIVE_SHOW)
    public void handleLiveShowEvent (@Valid LiveShowDTO showDTO) {
        liveShowService.handleLiveShowEvent(liveShowMapper.mapToLiveShow(showDTO));
    }
}

package com.tsts.listener.client.messaging.show.liveshow;

import com.tsts.listener.domain.show.liveshow.LiveShowService;
import com.tsts.listener.dto.show.liveshow.LiveShowDTO;
import com.tsts.listener.mapper.show.liveshow.LiveShowMapper;
import org.springframework.cloud.stream.annotation.StreamListener;

import javax.validation.Valid;

import static com.tsts.listener.configuration.messaging.channels.ShowChannels.LIVE_SHOW;

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

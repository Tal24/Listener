package com.tsts.listener.show.liveshow;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface LiveShowEvent {

    String LIVE_SHOW = "live-show";

    @Input(LIVE_SHOW)
    SubscribableChannel liveShow();

}

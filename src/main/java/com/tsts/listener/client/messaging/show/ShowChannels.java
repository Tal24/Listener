package com.tsts.listener.client.messaging.show;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ShowChannels {

    String NEW_SHOW = "new-show";
    String LIVE_SHOW = "live-show";

    @Input(NEW_SHOW)
    SubscribableChannel newShow();

    @Input(LIVE_SHOW)
    SubscribableChannel liveShow();
}

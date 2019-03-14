package com.tsts.listener.show.newshow;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface NewShowEvent {

    String NEW_SHOW = "new-show";

    @Input(NEW_SHOW)
    SubscribableChannel newShow();
}

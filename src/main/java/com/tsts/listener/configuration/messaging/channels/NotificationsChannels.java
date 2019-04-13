package com.tsts.listener.configuration.messaging.channels;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface NotificationsChannels {

    String NEW_SHOW_LISTENER_NOTIFICATION = "new-show-listener-notification";

    @Output(NEW_SHOW_LISTENER_NOTIFICATION)
    MessageChannel newShowNotificationToListeners ();

}

package com.tsts.listener.notification;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class PushNotificationToListenersService {

    private NotificationsChannels notificationsChannels;

    public PushNotificationToListenersService (NotificationsChannels notificationsChannels) {
        this.notificationsChannels = notificationsChannels;
    }

    public void notifyNewShow (NewShowListenerNotification newShowListenerNotification) {
        Message<NewShowListenerNotification> newShowNotificationMessage = MessageBuilder.withPayload(newShowListenerNotification).build();
        notificationsChannels.newShowNotificationToListeners().send(newShowNotificationMessage);
    }
}

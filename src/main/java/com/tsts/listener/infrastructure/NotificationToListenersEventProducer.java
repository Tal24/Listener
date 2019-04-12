package com.tsts.listener.infrastructure;

import com.tsts.listener.client.messaging.notification.NewShowListenerNotificationDTO;
import com.tsts.listener.client.messaging.notification.NotificationsChannels;
import com.tsts.listener.domain.notification.NewShowListenerNotification;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class NotificationToListenersEventProducer {

    private final NotificationsChannels notificationsChannels;
    private final NotificationMapper notificationMapper;

    public NotificationToListenersEventProducer (NotificationsChannels notificationsChannels,
                                                 NotificationMapper notificationMapper) {
        this.notificationsChannels = notificationsChannels;
        this.notificationMapper = notificationMapper;
    }

    public void notifyNewShow (NewShowListenerNotification newShowListenerNotification) {
        NewShowListenerNotificationDTO newShowListenerNotificationDTO = notificationMapper.mapToNewShowListenerNotificationDTO(newShowListenerNotification);
        Message<NewShowListenerNotificationDTO> newShowNotificationMessage = MessageBuilder.withPayload(newShowListenerNotificationDTO).build();
        notificationsChannels.newShowNotificationToListeners().send(newShowNotificationMessage);
    }
}

package com.tsts.listener.mapper.notification;

import com.tsts.listener.domain.notification.NewShowListenerNotification;
import com.tsts.listener.dto.notification.NewShowListenerNotificationDTO;
import com.tsts.listener.mapper.listenerdetails.ListenerDetailsMapper;
import com.tsts.listener.mapper.show.ShowMapper;

public class NotificationMapper {

    private final ShowMapper showMapper;
    private final ListenerDetailsMapper listenerDetailsMapper;

    public NotificationMapper (ShowMapper showMapper, ListenerDetailsMapper listenerDetailsMapper) {
        this.showMapper = showMapper;
        this.listenerDetailsMapper = listenerDetailsMapper;
    }

    public NewShowListenerNotificationDTO mapToNewShowListenerNotificationDTO (NewShowListenerNotification newShowListenerNotification) {
        return new NewShowListenerNotificationDTO(showMapper.mapToShowDTO(newShowListenerNotification.getShow()), listenerDetailsMapper.mapToListenerDTOs(newShowListenerNotification.getListeners()));
    }
}

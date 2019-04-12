package com.tsts.listener.client.messaging.notification;

import com.tsts.listener.client.messaging.show.ShowDTO;
import com.tsts.listener.client.rest.listenerdetails.ListenerDTO;
import lombok.Value;

import java.util.List;

@Value
public class NewShowListenerNotificationDTO {

    private ShowDTO show;
    private List<ListenerDTO> listeners;

}

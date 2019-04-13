package com.tsts.listener.dto.notification;

import com.tsts.listener.dto.listenerdetails.ListenerDTO;
import com.tsts.listener.dto.show.ShowDTO;
import lombok.Value;

import java.util.List;

@Value
public class NewShowListenerNotificationDTO {

    private ShowDTO show;
    private List<ListenerDTO> listeners;

}

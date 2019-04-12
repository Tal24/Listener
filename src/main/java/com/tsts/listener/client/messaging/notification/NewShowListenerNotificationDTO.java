package com.tsts.listener.client.messaging.notification;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tsts.listener.client.messaging.show.ShowDTO;
import com.tsts.listener.client.rest.listenerdetails.ListenerDTO;
import lombok.Value;

import java.util.List;

@Value
public class NewShowListenerNotificationDTO {

    private ShowDTO show;
    private List<ListenerDTO> listeners;

    @JsonCreator
    public NewShowListenerNotificationDTO (@JsonProperty("show") ShowDTO show, @JsonProperty("listeners") List<ListenerDTO> listeners) {
        this.show = show;
        this.listeners = listeners;
    }
}

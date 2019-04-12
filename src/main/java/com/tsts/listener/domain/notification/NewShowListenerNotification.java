package com.tsts.listener.domain.notification;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tsts.listener.domain.entity.Listener;
import com.tsts.listener.domain.entity.Show;
import lombok.Value;

import java.util.List;

@Value
public class NewShowListenerNotification {

    private Show show;
    private List<Listener> listeners;

    @JsonCreator
    public NewShowListenerNotification (@JsonProperty("show") Show show, @JsonProperty("listeners") List<Listener> listeners) {
        this.show = show;
        this.listeners = listeners;
    }
}

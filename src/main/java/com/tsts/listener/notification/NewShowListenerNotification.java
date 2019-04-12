package com.tsts.listener.notification;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tsts.listener.domain.Listener;
import com.tsts.listener.domain.Show;
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

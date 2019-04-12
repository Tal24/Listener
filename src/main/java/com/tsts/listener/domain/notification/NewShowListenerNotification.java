package com.tsts.listener.domain.notification;

import com.tsts.listener.domain.entity.Listener;
import com.tsts.listener.domain.entity.Show;
import lombok.Value;

import java.util.List;

@Value
public class NewShowListenerNotification {

    private final Show show;
    private final List<Listener> listeners;

}

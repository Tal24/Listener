package com.tsts.listener.notification;

import com.tsts.listener.domain.Listener;
import com.tsts.listener.newshow.Show;

import java.text.MessageFormat;
import java.util.List;

public class PushNotificationService {

    public void notifyNewShow (Show show, List<Listener> listeners) {
        listeners.forEach(listener -> {
            System.out.println(MessageFormat.format("Sending message to {0} ...", listener.getFullName()));
            System.out.println(MessageFormat.format("Listen to our new show: {0}", show.getName()));
        });
    }
}

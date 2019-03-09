package com.tsts.listener.newshow;

import com.tsts.listener.domain.Listener;
import com.tsts.listener.listener.details.ListenerDetailsService;
import com.tsts.listener.notification.PushNotificationService;

import java.util.List;

public class NewShowService {

    private final ListenerDetailsService listenerDetailsService;
    private final PushNotificationService pushNotificationService;

    public NewShowService (ListenerDetailsService listenerDetailsService,
                           PushNotificationService pushNotificationService) {
        this.listenerDetailsService = listenerDetailsService;
        this.pushNotificationService = pushNotificationService;
    }


    public void handleNewShowEvent (Show show) {
        List<Listener> listeners = listenerDetailsService.getListenersByFavoriteCategory(show.getCategory());
        pushNotificationService.notifyNewShow(show, listeners);
    }
}

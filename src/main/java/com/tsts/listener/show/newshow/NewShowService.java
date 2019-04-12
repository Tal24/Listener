package com.tsts.listener.show.newshow;

import com.tsts.listener.domain.Listener;
import com.tsts.listener.domain.Show;
import com.tsts.listener.listener.details.ListenerDetailsService;
import com.tsts.listener.notification.NewShowListenerNotification;
import com.tsts.listener.notification.PushNotificationToListenersService;
import com.tsts.listener.show.details.ShowDetailsRepository;

import java.util.List;

public class NewShowService {

    private final ListenerDetailsService listenerDetailsService;
    private final PushNotificationToListenersService pushNotificationToListenersService;
    private final ShowDetailsRepository showDetailsRepository;

    public NewShowService (ListenerDetailsService listenerDetailsService,
                           PushNotificationToListenersService pushNotificationToListenersService,
                           ShowDetailsRepository showDetailsRepository) {
        this.listenerDetailsService = listenerDetailsService;
        this.pushNotificationToListenersService = pushNotificationToListenersService;
        this.showDetailsRepository = showDetailsRepository;
    }


    public void handleNewShowEvent (Show show) {
        showDetailsRepository.save(show);
        List<Listener> listeners = listenerDetailsService.getListenersByFavoriteCategory(show.getCategory());
        NewShowListenerNotification newShowListenerNotification = new NewShowListenerNotification(show, listeners);
        pushNotificationToListenersService.notifyNewShow(newShowListenerNotification);
    }
}

package com.tsts.listener.domain.show.newshow;

import com.tsts.listener.domain.entity.Listener;
import com.tsts.listener.domain.entity.Show;
import com.tsts.listener.domain.listener.details.ListenerDetailsService;
import com.tsts.listener.domain.notification.NewShowListenerNotification;
import com.tsts.listener.domain.notification.PushNotificationToListenersService;
import com.tsts.listener.domain.show.details.ShowDetailsRepository;

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

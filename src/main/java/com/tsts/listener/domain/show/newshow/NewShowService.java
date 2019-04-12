package com.tsts.listener.domain.show.newshow;

import com.tsts.listener.domain.entity.Listener;
import com.tsts.listener.domain.entity.Show;
import com.tsts.listener.domain.listener.details.ListenerDetailsService;
import com.tsts.listener.domain.notification.NewShowListenerNotification;
import com.tsts.listener.infrastructure.NotificationToListenersEventProducer;
import com.tsts.listener.domain.show.details.ShowDetailsRepository;

import java.util.List;

public class NewShowService {

    private final ListenerDetailsService listenerDetailsService;
    private final NotificationToListenersEventProducer notificationToListenersEventProducer;
    private final ShowDetailsRepository showDetailsRepository;

    public NewShowService (ListenerDetailsService listenerDetailsService,
                           NotificationToListenersEventProducer notificationToListenersEventProducer,
                           ShowDetailsRepository showDetailsRepository) {
        this.listenerDetailsService = listenerDetailsService;
        this.notificationToListenersEventProducer = notificationToListenersEventProducer;
        this.showDetailsRepository = showDetailsRepository;
    }


    public void handleNewShowEvent (Show show) {
        showDetailsRepository.save(show);
        List<Listener> listeners = listenerDetailsService.getListenersByFavoriteCategory(show.getCategory());
        NewShowListenerNotification newShowListenerNotification = new NewShowListenerNotification(show, listeners);
        notificationToListenersEventProducer.notifyNewShow(newShowListenerNotification);
    }
}

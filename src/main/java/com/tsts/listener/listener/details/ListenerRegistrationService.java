package com.tsts.listener.listener.details;

import com.tsts.listener.domain.Listener;

public class ListenerRegistrationService {

    private final ListenerDetailsRepository listenerDetailsRepository;

    public ListenerRegistrationService (ListenerDetailsRepository listenerDetailsRepository) {
        this.listenerDetailsRepository = listenerDetailsRepository;
    }

    public Listener register (Listener listener) {
        return listenerDetailsRepository.save(listener);
    }
}

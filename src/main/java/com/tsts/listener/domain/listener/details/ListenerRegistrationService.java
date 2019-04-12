package com.tsts.listener.domain.listener.details;

import com.tsts.listener.domain.entity.Listener;

public class ListenerRegistrationService {

    private final ListenerDetailsRepository listenerDetailsRepository;

    public ListenerRegistrationService (ListenerDetailsRepository listenerDetailsRepository) {
        this.listenerDetailsRepository = listenerDetailsRepository;
    }

    public Listener register (Listener listener) {
        return listenerDetailsRepository.save(listener);
    }
}

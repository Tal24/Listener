package com.tsts.listener.listener.details;

import com.tsts.listener.domain.Category;
import com.tsts.listener.domain.Listener;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ListenerDetailsService {

    private final ListenerDetailsRepository listenerDetailsRepository;

    public ListenerDetailsService (ListenerDetailsRepository listenerDetailsRepository) {
        this.listenerDetailsRepository = listenerDetailsRepository;
    }

    public List<Listener> getListenersByFavoriteCategory (Category category) {
        return listenerDetailsRepository.findAllByFavoriteCategoriesContaining(category);
    }

    public Optional<Listener> getListenerDetails (String id) {
        return listenerDetailsRepository.findById(UUID.fromString(id));
    }
}

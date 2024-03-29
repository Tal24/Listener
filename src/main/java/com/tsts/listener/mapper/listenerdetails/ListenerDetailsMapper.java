package com.tsts.listener.mapper.listenerdetails;

import com.tsts.listener.domain.entity.Days;
import com.tsts.listener.domain.entity.Listener;
import com.tsts.listener.domain.entity.Name;
import com.tsts.listener.domain.entity.PhoneNumber;
import com.tsts.listener.dto.listenerdetails.ListenerDTO;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ListenerDetailsMapper {

    public Listener mapToListener (ListenerDTO listenerDTO) {
        Listener listener = new Listener(UUID.fromString(listenerDTO.getId()), new Name(listenerDTO.getFirstName()),
                new Name(listenerDTO.getLastName()), new PhoneNumber(listenerDTO.getPhoneNumber()));
        listenerDTO.getFavoriteCategories().forEach(listener::addFavoriteCategory);
        if (listenerDTO.isSuspended()) {
            listener.suspend(new Days(listenerDTO.getSuspendedPeriod()));
        }
        return listener;
    }

    public ListenerDTO mapToListenerDTO (Listener listener) {
        return ListenerDTO.builder(listener.getId().toString(), listener.getFirstName().get(), listener.getLastName().get(),
                listener.getPhoneNumber().get()).favoriteCategories(listener.getFavoriteCategories()).suspendedPeriod(listener.getSuspendedPeriod().get()).build();
    }

    public List<ListenerDTO> mapToListenerDTOs (List<Listener> listeners) {
        return listeners.stream().map(this::mapToListenerDTO).collect(Collectors.toList());
    }
}

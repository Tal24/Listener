package com.tsts.listener.client.messaging.show;

import com.tsts.listener.domain.entity.Name;
import com.tsts.listener.domain.entity.Show;

public class ShowMapper {

    public Show mapToShow (ShowDTO showDTO) {
        return new Show(new Name(showDTO.getName()), showDTO.getCategory(), showDTO.isListenersAllowedToCall());
    }

    public ShowDTO mapToShowDTO (Show show) {
        return ShowDTO.builder(show.getName().get(), show.getCategory()).listenersAllowedToCall(show.isListenersAllowedToCall()).build();
    }

}

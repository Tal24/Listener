package com.tsts.listener.mapper.show;

import com.tsts.listener.domain.entity.Name;
import com.tsts.listener.domain.entity.Show;
import com.tsts.listener.dto.show.ShowDTO;

public class ShowMapper {

    public Show mapToShow (ShowDTO showDTO) {
        return new Show(new Name(showDTO.getName()), showDTO.getCategory(), showDTO.isListenersAllowedToCall());
    }

    public ShowDTO mapToShowDTO (Show show) {
        return ShowDTO.builder(show.getName().get(), show.getCategory()).listenersAllowedToCall(show.isListenersAllowedToCall()).build();
    }

}

package com.tsts.listener.client.messaging.show.liveshow;

import com.tsts.listener.domain.entity.Name;
import com.tsts.listener.domain.show.liveshow.LiveShow;

public class LiveShowMapper {

    public LiveShow mapToLiveShow (LiveShowDTO liveShowDTO) {
        return new LiveShow(new Name(liveShowDTO.getName()), liveShowDTO.getEndDate());
    }

    public LiveShowDTO mapToLiveShowDTO (LiveShow liveShow) {
        return new LiveShowDTO(liveShow.getName().get(), liveShow.getEndDate());
    }

}

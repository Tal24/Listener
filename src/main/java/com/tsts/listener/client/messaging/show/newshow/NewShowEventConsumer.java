package com.tsts.listener.client.messaging.show.newshow;

import com.tsts.listener.domain.show.newshow.NewShowService;
import com.tsts.listener.dto.show.ShowDTO;
import com.tsts.listener.mapper.show.ShowMapper;
import org.springframework.cloud.stream.annotation.StreamListener;

import javax.validation.Valid;

import static com.tsts.listener.configuration.messaging.channels.ShowChannels.NEW_SHOW;

public class NewShowEventConsumer {

    private final NewShowService newShowService;
    private final ShowMapper showMapper;

    public NewShowEventConsumer (NewShowService newShowService, ShowMapper showMapper) {
        this.newShowService = newShowService;
        this.showMapper = showMapper;
    }

    @StreamListener(NEW_SHOW)
    public void handleNewShowEvent (@Valid ShowDTO showDTO) {
        newShowService.handleNewShowEvent(showMapper.mapToShow(showDTO));
    }
}

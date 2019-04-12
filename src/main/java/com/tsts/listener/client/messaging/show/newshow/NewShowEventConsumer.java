package com.tsts.listener.client.messaging.show.newshow;

import com.tsts.listener.client.messaging.show.ShowDTO;
import com.tsts.listener.client.messaging.show.ShowMapper;
import com.tsts.listener.domain.show.newshow.NewShowService;
import org.springframework.cloud.stream.annotation.StreamListener;

import javax.validation.Valid;

import static com.tsts.listener.client.messaging.show.ShowChannels.NEW_SHOW;

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

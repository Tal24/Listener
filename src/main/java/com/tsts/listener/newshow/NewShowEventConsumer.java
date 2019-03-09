package com.tsts.listener.newshow;

import org.springframework.cloud.stream.annotation.StreamListener;

import static com.tsts.listener.newshow.NewShowEvent.NEW_SHOW;

public class NewShowEventConsumer {

    @StreamListener(NEW_SHOW)
    public void handleNewShowEvent (Show show) {
        System.out.println(show);
    }
}

package com.tsts.listener.domain.show.liveshow;

public class LiveShowDetailsNotAvailableException extends RuntimeException {

    public LiveShowDetailsNotAvailableException () {
        super("Live show details are not available");
    }
}

package com.tsts.listener.domain.show.liveshow;

public class LiveShowInfoNotAvailableException extends RuntimeException {

    public LiveShowInfoNotAvailableException () {
        super("Live show info is not available");
    }
}
package com.tsts.listener.show.liveshow;

public class LiveShowInfoNotAvailableException extends RuntimeException {

    public LiveShowInfoNotAvailableException () {
        super("Live show info is not available");
    }
}

package com.tsts.listener.domain.show.details;

public class ShowNotAllowsListenersCallsException extends RuntimeException {

    public ShowNotAllowsListenersCallsException () {
        super("Listeners can not make a call to current live show");
    }
}

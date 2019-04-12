package com.tsts.listener.domain.show.details;

public class ShowNotAllowsListenersCalls extends RuntimeException {

    public ShowNotAllowsListenersCalls () {
        super("Listeners can not make a call to current live show");
    }
}

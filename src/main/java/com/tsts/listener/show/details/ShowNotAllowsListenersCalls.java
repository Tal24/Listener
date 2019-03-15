package com.tsts.listener.show.details;

public class ShowNotAllowsListenersCalls extends RuntimeException {

    public ShowNotAllowsListenersCalls () {
        super("Listeners can not make a call to current live show");
    }
}

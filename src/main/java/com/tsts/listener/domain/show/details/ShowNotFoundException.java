package com.tsts.listener.domain.show.details;

import java.text.MessageFormat;

public class ShowNotFoundException extends RuntimeException {

    public ShowNotFoundException (String showName) {
        super(MessageFormat.format("Not found show named {0}", showName));
    }
}

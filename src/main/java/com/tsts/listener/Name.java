package com.tsts.listener;

import java.text.MessageFormat;

public class Name {

    private String value;

    public Name (String value) {
        set(value);
    }

    public String get () {
        return value;
    }

    public void set (String value) {
        if (!value.matches("[A-Z,a-z]+")) {
            throw new IllegalArgumentException(MessageFormat.format("Invalid name - {0}, name should only have " +
                    "english letters", value));
        }
        this.value = value;
    }
}

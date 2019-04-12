package com.tsts.listener.domain.entity;

import lombok.EqualsAndHashCode;

import java.text.MessageFormat;

@EqualsAndHashCode
public class Name {

    private String value;

    public Name (String value) {
        set(value);
    }

    public String get () {
        return value;
    }

    public void set (String value) {
        if (!value.matches("[A-Za-z ]+")) {
            throw new IllegalArgumentException(MessageFormat.format("Invalid name - {0}, name should only have " +
                    "english letters", value));
        }
        this.value = value;
    }

    @Override
    public String toString () {
        return value;
    }
}

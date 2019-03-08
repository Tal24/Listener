package com.tsts.listener.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.text.MessageFormat;

public class Name {

    private String value;

    @JsonCreator
    public Name (String value) {
        set(value);
    }

    @JsonProperty("value")
    public String get () {
        return value;
    }

    @JsonSetter("value")
    public void set (String value) {
        if (!value.matches("[A-Z,a-z]+")) {
            throw new IllegalArgumentException(MessageFormat.format("Invalid name - {0}, name should only have " +
                    "english letters", value));
        }
        this.value = value;
    }
}

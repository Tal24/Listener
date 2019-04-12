package com.tsts.listener.domain.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.EqualsAndHashCode;

import java.text.MessageFormat;

@EqualsAndHashCode
public class Name {

    @JsonValue
    private String value;

    @JsonCreator
    public Name (String value) {
        set(value);
    }

    @JsonGetter("value")
    public String get () {
        return value;
    }

    @JsonSetter("value")
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

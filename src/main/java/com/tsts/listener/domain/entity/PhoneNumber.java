package com.tsts.listener.domain.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.EqualsAndHashCode;

import java.text.MessageFormat;

@EqualsAndHashCode
public class PhoneNumber {

    @JsonValue
    private String value;

    @JsonCreator
    public PhoneNumber (String value) {
        set(value);
    }

    @JsonGetter("value")
    public String get () {
        return value;
    }

    @JsonSetter("value")
    public void set (String value) {
        if (!value.matches("[-,0-9]+")) {
            throw new IllegalArgumentException(MessageFormat.format("Invalid phone number - {0}, phone number should " +
                    "only have numbers", value));
        }
        this.value = value;
    }

    @Override
    public String toString () {
        return value;
    }
}

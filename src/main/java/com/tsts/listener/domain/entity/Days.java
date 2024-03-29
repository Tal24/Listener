package com.tsts.listener.domain.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Days {

    private int value;

    public Days (int value) {
        set(value);
    }

    public int get () {
        return value;
    }

    public void set (int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Number of days cannot be negative");
        }
        this.value = value;
    }

    @Override
    public String toString () {
        return String.valueOf(value);
    }

}

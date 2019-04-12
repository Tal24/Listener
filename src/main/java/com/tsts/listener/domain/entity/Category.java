package com.tsts.listener.domain.entity;

public enum Category {
    NEWS,
    SPORTS,
    POLITICS,
    ENTERTAINMENT;

    @Override
    public String toString () {
        return name().toLowerCase();
    }
}

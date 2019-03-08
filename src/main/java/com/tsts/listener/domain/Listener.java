package com.tsts.listener.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Getter
public class Listener {

    @Id
    private UUID id;
    private Name firstName;
    private Name lastName;

    public Listener (Name firstName, Name lastName) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
    }

}

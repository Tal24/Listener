package com.tsts.listener;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.time.LocalDate;
import java.util.UUID;

@Getter
public class Listener {

    @Id
    private UUID id;
    private Name firstName;
    private Name lastName;

    @Transient
    private LocalDate dateOfBirth;

    public Listener (UUID id, Name firstName, Name lastName, LocalDate dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

}

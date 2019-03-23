package com.tsts.listener.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.validation.constraints.NotNull;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode
public class Listener {

    @Id
    @NotNull
    private UUID id;
    @NotNull
    private Name firstName;
    @NotNull
    private Name lastName;
    @NotNull
    private PhoneNumber phoneNumber;
    private List<Category> favoriteCategories = new ArrayList<>();
    private int suspendedPeriod;

    @PersistenceConstructor
    public Listener (UUID id, Name firstName, Name lastName, PhoneNumber phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    @JsonCreator
    private Listener (@JsonProperty("id") String id, @JsonProperty("firstName") String firstName,
                      @JsonProperty("lastName") String lastName, @JsonProperty("phoneNumber") String phoneNumber) {
        this.id = UUID.fromString(id);
        this.firstName = new Name(firstName);
        this.lastName = new Name(lastName);
        this.phoneNumber = new PhoneNumber(phoneNumber);
    }

    public boolean addFavoriteCategory (Category category) {
        return favoriteCategories.add(category);
    }

    public boolean removeFavoriteCategory (Category category) {
        return favoriteCategories.remove(category);
    }

    public UUID getId () {
        return id;
    }

    public Name getFirstName () {
        return firstName;
    }

    public Name getLastName () {
        return lastName;
    }

    public PhoneNumber getPhoneNumber () {
        return phoneNumber;
    }

    public boolean isSuspended () { return suspendedPeriod == 0; }

    public void setSuspendedPeriod (int suspendedPeriod) {
        if (suspendedPeriod <= 0) {
            throw new IllegalArgumentException("Suspended period must be greater than 0");
        }
        this.suspendedPeriod = suspendedPeriod;
    }

    public List<Category> getFavoriteCategories () {
        return Collections.unmodifiableList(favoriteCategories);
    }

    @JsonIgnore
    public String getFullName () {
        return MessageFormat.format("{0} {1}", getFirstName().get(), getLastName().get());
    }
}

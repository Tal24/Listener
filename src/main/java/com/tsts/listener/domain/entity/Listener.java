package com.tsts.listener.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode
@ToString
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
    private Days suspendedPeriod = new Days(0);

    public Listener (UUID id, Name firstName, Name lastName, PhoneNumber phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public boolean addFavoriteCategory (Category category) {
        return favoriteCategories.add(category);
    }

    public boolean removeFavoriteCategory (Category category) {
        return favoriteCategories.remove(category);
    }

    public boolean isSuspended () { return suspendedPeriod.get() != 0; }

    public void cancelSuspension () {
        this.suspendedPeriod = new Days(0);
    }

    public void suspend (Days days) {
        if (days.get() == 0) {
            throw new IllegalArgumentException("Suspended period must be greater than 0");
        }
        this.suspendedPeriod = days;
    }

    public List<Category> getFavoriteCategories () {
        return Collections.unmodifiableList(favoriteCategories);
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

    public Days getSuspendedPeriod () {
        return suspendedPeriod;
    }

}

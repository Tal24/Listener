package com.tsts.listener.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.data.annotation.Id;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Listener {

    @Id
    private UUID id;
    private Name firstName;
    private Name lastName;
    private PhoneNumber phoneNumber;
    private List<Category> favoriteCategories = new ArrayList<>();

    @JsonCreator
    public Listener (UUID id, String firstName, String lastName, PhoneNumber phoneNumber) {
        this.id = id;
        this.firstName = new Name(firstName);
        this.lastName = new Name(lastName);
        this.phoneNumber = phoneNumber;
    }

    public Listener (UUID id, String firstName, String lastName, Category category, PhoneNumber phoneNumber) {
        this(id, firstName, lastName, phoneNumber);
        addFavoriteCategory(category);
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

    public List<Category> getFavoriteCategories () {
        return Collections.unmodifiableList(favoriteCategories);
    }

    public String getFullName () {
        return MessageFormat.format("{0} {1}", getFirstName(), getLastName());
    }
}

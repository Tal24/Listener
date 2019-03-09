package com.tsts.listener.domain;

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
    private List<Category> favoriteCategories = new ArrayList<>();

    public Listener (String firstName, String lastName) {
        this.id = UUID.randomUUID();
        this.firstName = new Name(firstName);
        this.lastName = new Name(lastName);
    }

    public Listener (String firstName, String lastName, Category category) {
        this(firstName, lastName);
        addFavoriteCategory(category);
    }

    public boolean addFavoriteCategory (Category category) {
        return favoriteCategories.add(category);
    }

    public boolean removeFavoriteCategory (Category category) {
        return favoriteCategories.remove(category);
    }

    public String getId () {
        return id.toString();
    }

    public String getFirstName () {
        return firstName.get();
    }

    public String getLastName () {
        return lastName.get();
    }

    public List<Category> getFavoriteCategories () {
        return Collections.unmodifiableList(favoriteCategories);
    }

    public String getFullName () {
        return MessageFormat.format("{0} {1}", getFirstName(), getLastName());
    }
}

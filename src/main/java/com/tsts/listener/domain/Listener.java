package com.tsts.listener.domain;

import org.springframework.data.annotation.Id;

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

    public Listener (Name firstName, Name lastName) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
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

    public List<Category> getFavoriteCategories () {
        return Collections.unmodifiableList(favoriteCategories);
    }
}

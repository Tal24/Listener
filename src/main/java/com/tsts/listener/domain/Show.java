package com.tsts.listener.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@Value
public class Show {

    @Id
    @NotNull
    private Name name;
    @NotNull
    private Category category;
    private boolean listenersCalls;

    @JsonGetter("listenersCalls")
    public boolean listenersAllowedToCall () {
        return listenersCalls;
    }

    @JsonCreator
    public Show (@JsonProperty("name") @NotNull Name name, @JsonProperty("category") @NotNull Category category, @JsonProperty("listenersCalls") boolean listenersCalls) {
        this.name = name;
        this.category = category;
        this.listenersCalls = listenersCalls;
    }
}

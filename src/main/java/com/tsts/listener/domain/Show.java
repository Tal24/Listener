package com.tsts.listener.domain;

import com.fasterxml.jackson.annotation.JsonGetter;
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
    private boolean listenersTalk;

    @JsonGetter("listenersTalk")
    public boolean allowListenersTalk () {
        return listenersTalk;
    }

}

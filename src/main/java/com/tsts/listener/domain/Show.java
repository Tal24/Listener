package com.tsts.listener.domain;

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
    private boolean listenersTalks;

}

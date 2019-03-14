package com.tsts.listener.domain;

import lombok.Value;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Value
public class Show {

    @Id
    private UUID id;
    private Name name;
    private Category category;
    private boolean listenersTalks;

}

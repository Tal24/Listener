package com.tsts.listener.domain.entity;

import lombok.Value;
import org.springframework.data.annotation.Id;

@Value
public class Show {

    @Id
    private Name name;
    private Category category;
    private boolean listenersAllowedToCall;

}

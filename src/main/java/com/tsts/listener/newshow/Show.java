package com.tsts.listener.newshow;

import com.tsts.listener.domain.Category;
import com.tsts.listener.domain.Name;
import lombok.Value;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Value
public class Show {

    @Id
    private UUID id;
    private Name name;
    private Category category;

}

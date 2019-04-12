package com.tsts.listener.domain.show.liveshow;

import com.tsts.listener.domain.entity.Name;
import lombok.Value;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Value
public class LiveShow {

    @Id
    private Name name;
    private LocalDateTime endDate;

}

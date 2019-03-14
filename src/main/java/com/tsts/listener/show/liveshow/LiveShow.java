package com.tsts.listener.show.liveshow;

import com.tsts.listener.domain.Name;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class LiveShow {

    private Name name;
    private LocalDateTime endDate;
}

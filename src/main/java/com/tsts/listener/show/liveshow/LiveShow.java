package com.tsts.listener.show.liveshow;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.tsts.listener.domain.Name;
import lombok.Value;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Value
public class LiveShow {

    @Id
    @NotNull
    private Name name;
    @NotNull
    private LocalDateTime endDate;

    @JsonCreator
    public LiveShow (Name name, LocalDateTime endDate) {
        this.name = name;
        this.endDate = endDate;
    }

}

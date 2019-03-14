package com.tsts.listener.show.liveshow;

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

    public String getName () {
        return name.get();
    }

    public LocalDateTime getEndDate () {
        return endDate;
    }

}

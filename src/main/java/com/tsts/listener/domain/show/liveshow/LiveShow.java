package com.tsts.listener.domain.show.liveshow;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.tsts.listener.domain.entity.Name;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Value
public class LiveShow {

    @Id
    @NotNull
    private Name name;
    @NotNull
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime endDate;

    @PersistenceConstructor
    public LiveShow (Name name, LocalDateTime endDate) {
        this.name = name;
        this.endDate = endDate;
    }

    @JsonCreator
    private LiveShow (@JsonProperty("name") String name, @JsonProperty("endDate") LocalDateTime endDate) {
        this.name = new Name(name);
        this.endDate = endDate;
    }

}

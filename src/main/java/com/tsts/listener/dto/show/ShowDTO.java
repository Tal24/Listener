package com.tsts.listener.dto.show;

import com.tsts.listener.domain.entity.Category;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class ShowDTO {

    @NotNull
    private String name;
    private Category category;
    private boolean listenersAllowedToCall;

    public static ShowDTOBuilder builder (String name, Category category) {return new ShowDTOBuilder(name, category);}

    public static class ShowDTOBuilder {
        private @NotNull String name;
        private Category category;
        private boolean listenersAllowedToCall;

        ShowDTOBuilder (String name, Category category) {
            this.name = name;
            this.category = category;
        }

        public ShowDTOBuilder listenersAllowedToCall (boolean listenersAllowedToCall) {
            this.listenersAllowedToCall = listenersAllowedToCall;
            return this;
        }

        public ShowDTO build () {
            return new ShowDTO(name, category, listenersAllowedToCall);
        }

        public String toString () {return "ShowDTO.ShowDTOBuilder(name=" + this.name + ", category=" + this.category + ", listenersAllowedToCall=" + this.listenersAllowedToCall + ")";}
    }
}

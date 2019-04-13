package com.tsts.listener.dto.listenerdetails;

import com.tsts.listener.domain.entity.Category;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class ListenerDTO {

    @NotNull
    private String id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String phoneNumber;

    private List<Category> favoriteCategories;
    private boolean isSuspended;
    private int suspendedPeriod;

    public static ListenerDTOBuilder builder (@NotNull String id, @NotNull String firstName, @NotNull String lastName, @NotNull String phoneNumber) {
        return new ListenerDTOBuilder(id, firstName, lastName, phoneNumber);
    }

    public static class ListenerDTOBuilder {
        private @NotNull String id;
        private @NotNull String firstName;
        private @NotNull String lastName;
        private @NotNull String phoneNumber;
        private List<Category> favoriteCategories = new LinkedList<>();
        private boolean isSuspended = false;
        private int suspendedPeriod = 0;

        ListenerDTOBuilder (@NotNull String id, @NotNull String firstName, @NotNull String lastName,
                            @NotNull String phoneNumber) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
        }

        public ListenerDTOBuilder favoriteCategories (List<Category> favoriteCategories) {
            this.favoriteCategories = favoriteCategories;
            return this;
        }

        public ListenerDTOBuilder suspendedPeriod (int suspendedPeriod) {
            if (suspendedPeriod > 0) {
                this.isSuspended = true;
            }
            this.suspendedPeriod = suspendedPeriod;
            return this;
        }

        public ListenerDTO build () {
            return new ListenerDTO(id, firstName, lastName, phoneNumber, favoriteCategories, isSuspended, suspendedPeriod);
        }

        public String toString () {
            return "ListenerDTO.ListenerDTOBuilder(id=" + this.id + ", firstName=" + this.firstName + "," +
                    " lastName=" + this.lastName + ", phoneNumber=" + this.phoneNumber + ", favoriteCategories=" + this.favoriteCategories + ", isSuspended=" + this.isSuspended + ", suspendedPeriod=" + this.suspendedPeriod + ")";
        }
    }
}

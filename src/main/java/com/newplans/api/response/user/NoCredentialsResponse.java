package com.newplans.api.response.user;

import com.newplans.api.database.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NoCredentialsResponse {
    public Long id;
    public String name;
    public String surname;
    public String email;
    public String birthdayDate;

    public NoCredentialsResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.email = user.getEmail();
        this.birthdayDate = user.getBirthdayDate();
    }
}

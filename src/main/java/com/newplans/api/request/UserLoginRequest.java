package com.newplans.api.request;

import com.newplans.api.database.entity.User;
import com.newplans.api.exception.RequestValidationException;

import static com.newplans.api.security.RequestValidation.invalidEmail;
import static java.util.Objects.isNull;

public class UserLoginRequest {
    public String email;
    public String password;

    public User toEntity() throws RequestValidationException {
        this.validate();

        User loginUser = new User();

        loginUser.setEmail(email);
        loginUser.setPassword(password);

        return loginUser;
    }
    private void validate() throws RequestValidationException {
        if (isNull(email) || email.isEmpty()) {
            throw new RequestValidationException("Email cannot be empty or null");
        }
        if (invalidEmail(email)) {
            throw new RequestValidationException("Email is invalid");
        }

        if (isNull(password) || password.isEmpty()) {
            throw new RequestValidationException("Password cannot be empty or null");
        }
    }
}

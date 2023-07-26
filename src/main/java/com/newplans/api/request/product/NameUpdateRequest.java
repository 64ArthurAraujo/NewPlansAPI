package com.newplans.api.request.product;

import com.newplans.api.exception.RequestValidationException;

import static java.util.Objects.isNull;

public class NameUpdateRequest {
    public String name;
    public String adminToken;

    public void validate() throws RequestValidationException {
        if (isNull(name) || name.isEmpty()) {
            throw new RequestValidationException("Name cannot be empty or null");
        }

        if (isNull(adminToken) || adminToken.isEmpty()) {
            throw new RequestValidationException("adminToken cannot be empty or null");
        }
    }

    public String getName() throws RequestValidationException {
        this.validate();
        return name;
    }

    public String getAdminToken() throws RequestValidationException {
        this.validate();
        return adminToken;
    }
}

package com.newplans.api.request;

import com.newplans.api.exception.RequestValidationException;
import lombok.Getter;
import lombok.Setter;

import static java.util.Objects.isNull;

@Getter
@Setter
public class ProductNameUpdateRequest {
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
}

package com.newplans.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNameUpdateRequest {
    public String name;
    public String adminToken;
}

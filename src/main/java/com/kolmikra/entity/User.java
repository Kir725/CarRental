package com.kolmikra.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends AbstractEntity{

    private String email;

    private String password;

    private String userType;

    private Integer clientId;
}

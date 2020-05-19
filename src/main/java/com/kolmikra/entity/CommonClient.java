package com.kolmikra.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class CommonClient extends AbstractEntity{

    protected String name;

    protected String type;

    protected Double phone;

    protected String email;
}

package com.kolmikra.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class LegalClient extends CommonClient{

    private String agent;

    private Integer organizationCode;

}

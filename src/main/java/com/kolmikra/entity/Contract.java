package com.kolmikra.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class Contract extends AbstractEntity{

    private Date startDate;

    private Date dropOffDate;

    private Double rentalCost;

    private Integer clientId;

    private Integer vehicleId;
}

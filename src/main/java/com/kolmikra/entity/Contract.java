package com.kolmikra.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class Contract extends AbstractEntity{

    private Date startDate;

    private Integer rentalTime;

    private Double rentalCost;

    private Integer clientId;

    private Integer vehicleId;
}

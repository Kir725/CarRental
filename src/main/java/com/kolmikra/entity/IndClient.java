package com.kolmikra.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class IndClient extends CommonClient {

    private String secondName;

    private String middleName;

    private Integer drivingExperience;

    private Integer passportSeries;

    private Integer passportId;

    private Date birthDate;

}

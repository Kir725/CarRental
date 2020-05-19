package com.kolmikra.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kolmikra.entityDao.AbstractEntityDao;
import com.kolmikra.entityDao.IndClientDao;
import com.kolmikra.entityDao.VehicleDao;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class IndClient extends CommonClient{

    private String secondName;

    private String middleName;

    private Integer drivingExperience;

    private Integer passportSeries;

    private Integer passportId;

    private Date birthDate;

    @Override
    @JsonIgnore
    public IndClientDao getDaoEntity() {
        return new IndClientDao(this);
    }

    public IndClient(IndClientDao clientDao) {
        this.id = clientDao.getId();
        this.name = clientDao.getName();
        this.secondName = clientDao.getSecondName();
        this.middleName = clientDao.getMiddleName();
        this.type = clientDao.getType();
        this.phone = clientDao.getPhone();
        this.email = clientDao.getEmail();
        this.drivingExperience = clientDao.getDrivingExperience();
        this.passportSeries = clientDao.getPassportSeries();
        this.passportId = clientDao.getPassportId();
        this.birthDate = clientDao.getBirthDate();
    }
}

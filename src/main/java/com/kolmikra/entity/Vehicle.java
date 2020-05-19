package com.kolmikra.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kolmikra.entityDao.AbstractEntityDao;
import com.kolmikra.entityDao.VehicleDao;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Vehicle extends AbstractEntity{


    private String regPlate;

    private String model;

    private String make;

    private String vehicleClass;

    private String type;

    private String color;

    private Integer issueYear;

    private Double insuranceCost;

    private Integer capacity;

    private Double rentalCostPerDay;

    private Double bail;

    private Boolean rented;

    public Vehicle() {

    }

    public Vehicle(int id, String regPlate, String model, String make, String vehicleClass, String type, String color, Integer issueYear, Double insuranceCost, Integer capacity, Double rentalCostPerDay, Double bail, Boolean rented) {
        this.id = id;
        this.regPlate = regPlate;
        this.model = model;
        this.make = make;
        this.vehicleClass = vehicleClass;
        this.type = type;
        this.color = color;
        this.issueYear = issueYear;
        this.insuranceCost = insuranceCost;
        this.capacity = capacity;
        this.rentalCostPerDay = rentalCostPerDay;
        this.bail = bail;
        this.rented = rented;
    }

    public Vehicle(VehicleDao vehicleDao) {
        this.id = vehicleDao.getId();
        this.regPlate = vehicleDao.getRegPlate();
        this.model = vehicleDao.getModel();
        this.make = vehicleDao.getMake();
        this.vehicleClass = vehicleDao.getVehicleClass();
        this.type = vehicleDao.getType();
        this.color = vehicleDao.getColor();
        this.issueYear = vehicleDao.getIssueYear();
        this.insuranceCost = vehicleDao.getInsuranceCost();
        this.capacity = vehicleDao.getCapacity();
        this.rentalCostPerDay = vehicleDao.getRentalCostPerDay();
        this.bail = vehicleDao.getBail();
        this.rented = vehicleDao.isRented();
    }

    @Override
    @JsonIgnore
    public VehicleDao getDaoEntity() {
        return new VehicleDao(this);
    }
}

package com.kolmikra.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Vehicle extends AbstractEntity {


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

    private String vehicleImage;

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

}

package com.kolmikra.entityDao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kolmikra.entity.Vehicle;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "object")
@Data
public class VehicleDao extends AbstractEntityDao {


    public VehicleDao() {
    }

    public String getRegPlate(){
        return this.getValue(1).getVarcharValue();
    }

    public String getModel(){
        return this.getValue(2).getVarcharValue();
    }

    public String getMake(){
        return this.getValue(3).getVarcharValue();
    }

    public String getVehicleClass(){
        return this.getValue(4).getVarcharValue();
    }

    public String getType(){
        return this.getValue(5).getVarcharValue();
    }

    public String getColor(){
        return this.getValue(6).getVarcharValue();
    }

    public Integer getIssueYear(){
        return this.getValue(7).getIntegerValue();
    }

    public Double getInsuranceCost(){
        return this.getValue(8).getDecimalValue();
    }

    public Integer getCapacity(){
        return this.getValue(9).getIntegerValue();
    }

    public Double getRentalCostPerDay(){
        return this.getValue(10).getDecimalValue();
    }

    public Double getBail(){
        return this.getValue(29).getDecimalValue();
    }

    public Boolean isRented(){
        return this.getValue(11).getBooleanValue();
    }

    @Override
    @JsonIgnore
    public Vehicle getRealEntity(){
        return new Vehicle(this);
    }

    public VehicleDao(Vehicle vehicle) {

        this.setType_id(1);

        List<Value<AbstractEntityDao>> newValues = new ArrayList<>();
        Collections.addAll(newValues,
                new Value<>(this,1,vehicle.getRegPlate()),
                new Value<>(this,2,vehicle.getModel()),
                new Value<>(this,3,vehicle.getMake()),
                new Value<>(this,4,vehicle.getVehicleClass()),
                new Value<>(this,5,vehicle.getType()),
                new Value<>(this,6,vehicle.getColor()),
                new Value<>(this,7,vehicle.getIssueYear()),
                new Value<>(this,8,vehicle.getInsuranceCost()),
                new Value<>(this,9,vehicle.getCapacity()),
                new Value<>(this,10,vehicle.getRentalCostPerDay()),
                new Value<>(this,29,vehicle.getBail()),
                new Value<>(this,11,vehicle.getRented()));

        this.setValues(newValues);
    }
}

package com.kolmikra.entity.factory.impl;

import com.kolmikra.entity.AbstractEntity;
import com.kolmikra.entity.Vehicle;
import com.kolmikra.entity.factory.EntityFactory;
import com.kolmikra.entityDao.CommonEntityDao;

import com.kolmikra.entityDao.Value;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.kolmikra.attribute.AttributeTitle.*;

@Service
public class VehicleFactory implements EntityFactory {
    @Override
    public AbstractEntity getRealEntity(CommonEntityDao commonEntityDao) {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(commonEntityDao.getId());
        vehicle.setRegPlate(commonEntityDao.getRegPlate());
        vehicle.setModel(commonEntityDao.getModel());
        vehicle.setMake(commonEntityDao.getMake());
        vehicle.setVehicleClass(commonEntityDao.getVehicleClass());
        vehicle.setType(commonEntityDao.getVehicleType());
        vehicle.setCapacity(commonEntityDao.getCapacity());
        vehicle.setColor(commonEntityDao.getColor());
        vehicle.setIssueYear(commonEntityDao.getIssueYear());
        vehicle.setRentalCostPerDay(commonEntityDao.getRentalCostPerDay());
        vehicle.setInsuranceCost(commonEntityDao.getInsuranceCost());
        vehicle.setRented(commonEntityDao.isRented());
        vehicle.setBail(commonEntityDao.getBail());
        vehicle.setVehicleImage(commonEntityDao.getVehicleImage());
        return vehicle;
    }

    @Override
    public CommonEntityDao getDaoEntity(AbstractEntity abstractEntity) {
        if (abstractEntity instanceof Vehicle) {
            CommonEntityDao commonEntityDao = new CommonEntityDao();
            commonEntityDao.setType_id(1);
            List<Value> newValues = new ArrayList<>();
            Collections.addAll(newValues,
                    new Value(commonEntityDao, regPlateNumb, ((Vehicle) abstractEntity).getRegPlate()),
                    new Value(commonEntityDao, modelNumb, ((Vehicle) abstractEntity).getModel()),
                    new Value(commonEntityDao, makeNumb, ((Vehicle) abstractEntity).getMake()),
                    new Value(commonEntityDao, vehicleClassNumb, ((Vehicle) abstractEntity).getVehicleClass()),
                    new Value(commonEntityDao, vehicleTypeNumb, ((Vehicle) abstractEntity).getType()),
                    new Value(commonEntityDao, colorNumb, ((Vehicle) abstractEntity).getColor()),
                    new Value(commonEntityDao, issueYearNumb, ((Vehicle) abstractEntity).getIssueYear()),
                    new Value(commonEntityDao, insuranceCostNumb, ((Vehicle) abstractEntity).getInsuranceCost()),
                    new Value(commonEntityDao, capasityNumb, ((Vehicle) abstractEntity).getCapacity()),
                    new Value(commonEntityDao, rentalCostPerDayNumb, ((Vehicle) abstractEntity).getRentalCostPerDay()),
                    new Value(commonEntityDao, bailNumb, ((Vehicle) abstractEntity).getBail()),
                    new Value(commonEntityDao, rentedNumb, ((Vehicle) abstractEntity).getRented()),
                    new Value(commonEntityDao, vehicleImage, (((Vehicle) abstractEntity).getVehicleImage())));

            commonEntityDao.setValues(newValues);
            return commonEntityDao;

        }
        throw new ClassCastException();
    }
}

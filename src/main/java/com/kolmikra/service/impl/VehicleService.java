package com.kolmikra.service.impl;

import com.kolmikra.entity.Vehicle;
import com.kolmikra.entity.factory.impl.VehicleFactory;
import com.kolmikra.entityDao.CommonEntityDao;
import com.kolmikra.repository.VehicleRepository;
import com.kolmikra.service.impl.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService extends AbstractService<Vehicle, VehicleFactory, VehicleRepository> {

    @Autowired
    VehicleRepository vehicleRepository;

    public List<Vehicle> findNotInRent(String pickupDateString, String dropOffDateString) {
        Date pickupDate = Date.valueOf(pickupDateString);
        Date dropOffDate = Date.valueOf(dropOffDateString);
        List<CommonEntityDao> entityDaoList = repository.findNotInRent(pickupDate,dropOffDate);
        List<Vehicle> result = new ArrayList<>();
        entityDaoList.forEach(e -> {
            result.add((Vehicle)entityFactory.getRealEntity(e));
        });
        return result;
    }
}



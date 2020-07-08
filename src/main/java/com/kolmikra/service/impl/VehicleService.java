package com.kolmikra.service.impl;

import com.kolmikra.entity.Vehicle;
import com.kolmikra.entity.factory.impl.UserFactory;
import com.kolmikra.entity.factory.impl.VehicleFactory;
import com.kolmikra.entityDao.CommonEntityDao;
import com.kolmikra.repository.UserRepository;
import com.kolmikra.repository.VehicleRepository;
import com.kolmikra.service.impl.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService extends AbstractService<Vehicle, VehicleFactory, VehicleRepository> {


    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository, VehicleFactory vehicleFactory) {
        super(vehicleRepository, vehicleFactory);
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> findNotInRent(String pickupDateString, String dropOffDateString) {
        Date pickupDate = Date.valueOf(pickupDateString);
        Date dropOffDate = Date.valueOf(dropOffDateString);
        List<CommonEntityDao> entityDaoList = vehicleRepository.findNotInRent(pickupDate, dropOffDate);
        List<Vehicle> result = new ArrayList<>();
        entityDaoList.forEach(e -> {
            result.add((Vehicle) entityFactory.getRealEntity(e));
        });
        return result;
    }

    public void saveCarImage(MultipartFile file) {
        String path = "C:\\Users\\kirill\\IdeaProjects\\CarRental\\src\\main\\resources\\static\\assets\\images\\cars\\";
        String finalPath = path + file.getOriginalFilename();
        File destFile = new File(finalPath);
        try {
            file.transferTo(destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



package com.kolmikra.service;

import com.kolmikra.entity.Vehicle;
import com.kolmikra.entityDao.VehicleDao;
import com.kolmikra.exception.NoSuchItemException;
import com.kolmikra.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService extends AbstractService<VehicleDao,Vehicle, VehicleRepository> {

    @Autowired
    VehicleRepository vehicleRepository;

    public List<Vehicle> findAll() {
        List<VehicleDao> vehicleDaoList = vehicleRepository.findAll();
        return vehicleDaoList.stream().map(Vehicle::new).collect(Collectors.toList());
    }

//    public Vehicle findById(int id) throws NoSuchItemException {
//        VehicleDao vehicleDao = vehicleRepository.findById(id).orElseThrow(NoSuchItemException::new);
//        return new Vehicle(vehicleDao);
//    }

//    public void create(Vehicle vehicle){
//        vehicleRepository.save(new VehicleDao(vehicle));
//    }
//
//
//    public void deleteById(int id) throws NoSuchItemException {
//        if (vehicleRepository.existsById(id)) {
//            vehicleRepository.deleteById(id);
//        } else {
//            throw new NoSuchItemException();
//        }
//    }
//
//
//    public Vehicle updateVehicle (int id, Vehicle vehicle) throws NoSuchItemException {
//        if (vehicleRepository.existsById(id)) {
//            VehicleDao updated = new VehicleDao(vehicle);
//            updated.setId(id);
//            vehicleRepository.save(updated);
//            vehicle.setId(id);
//            return vehicle;
//        }
//        throw new NoSuchItemException();
//    }
}

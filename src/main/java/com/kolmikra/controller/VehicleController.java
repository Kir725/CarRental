package com.kolmikra.controller;

import com.kolmikra.entity.Vehicle;
import com.kolmikra.exception.NoSuchItemException;
import com.kolmikra.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController extends AbstractController<Vehicle,VehicleService>{

    @Autowired
    VehicleService vehicleService;

//    @GetMapping("/find")
//    public ResponseEntity<Vehicle> findById(@RequestParam int id) {
//        try {
//            Vehicle vehicle = vehicleService.findById(id);
//            return ResponseEntity.ok(vehicle);
//        } catch (NoSuchItemException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @GetMapping("/find/all")
    public List<Vehicle> findAllBooks() {
        return vehicleService.findAll();
    }

//    @PostMapping("/create")
//    @ResponseStatus(code = HttpStatus.CREATED)
//    public void create(@RequestBody Vehicle vehicle) {
//        vehicleService.create(vehicle);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public HttpStatus delete(@PathVariable int id) {
//        try {
//            vehicleService.deleteById(id);
//            return HttpStatus.OK;
//        } catch (NoSuchItemException e) {
//            return HttpStatus.NOT_FOUND;
//        }
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Vehicle> update(@PathVariable int id, @RequestBody Vehicle vehicle) {
//        try {
//            Vehicle updated = vehicleService.updateVehicle(id, vehicle);
//            return ResponseEntity.ok(updated);
//        } catch (NoSuchItemException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//        }
//    }



}

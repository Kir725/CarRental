package com.kolmikra.controller.impl;

import com.kolmikra.controller.AbstractController;
import com.kolmikra.entity.Vehicle;
import com.kolmikra.service.impl.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin
public class VehicleController extends AbstractController<Vehicle, VehicleService> {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        super(vehicleService);
        this.vehicleService = vehicleService;
    }

    @GetMapping("/findNotInRent/{pickupDate}/{dropOffDate}")
    public List<Vehicle> findNotInRent(@PathVariable("pickupDate") String pickupDate,
                                       @PathVariable("dropOffDate") String dropOffDate) {
        return vehicleService.findNotInRent(pickupDate, dropOffDate);
    }

    @PostMapping("/uploadImage")
    public void carImageUpload(@RequestParam("carImage") MultipartFile file) {
        vehicleService.saveCarImage(file);
    }


}

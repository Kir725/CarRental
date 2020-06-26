package com.kolmikra.controller.impl;

import com.kolmikra.controller.AbstractController;
import com.kolmikra.entity.Vehicle;
import com.kolmikra.service.impl.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin
public class VehicleController extends AbstractController<Vehicle,VehicleService> {

    @Autowired
    VehicleService vehicleService;

    @GetMapping("/findNotInRent/{pickupDate}/{dropOffDate}")
    public List<Vehicle> findNotInRent(@PathVariable("pickupDate") String pickupDate,
                                                       @PathVariable("dropOffDate") String dropOffDate) {
        return vehicleService.findNotInRent(pickupDate,dropOffDate);
    }


}

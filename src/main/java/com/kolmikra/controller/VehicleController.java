package com.kolmikra.controller;

import com.kolmikra.entity.Vehicle;
import com.kolmikra.service.impl.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
public class VehicleController extends AbstractController<Vehicle,VehicleService>{

    @Autowired
    VehicleService vehicleService;

}

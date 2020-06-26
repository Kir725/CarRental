package com.kolmikra.controller.impl;

import com.kolmikra.controller.AbstractController;
import com.kolmikra.entity.User;
import com.kolmikra.entity.Vehicle;
import com.kolmikra.exception.NoSuchItemException;
import com.kolmikra.service.impl.UserService;
import com.kolmikra.service.impl.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController extends AbstractController<User, UserService> {

    @Autowired
    UserService userService;

    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable String email){
        try {
            User user = userService.findByEmail(email);
            return ResponseEntity.ok(user);
        } catch (NoSuchItemException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

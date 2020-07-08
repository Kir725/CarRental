package com.kolmikra.controller.impl;

import com.kolmikra.controller.AbstractController;
import com.kolmikra.entity.User;
import com.kolmikra.entity.Vehicle;
import com.kolmikra.exception.NoSuchItemException;
import com.kolmikra.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController extends AbstractController<User, UserService> {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        super(userService);
        this.userService = userService;
    }

    @GetMapping("/findByEmail/{email}")
    public User findByEmail(@PathVariable String email) {
        try {
            return userService.findByEmail(email);
        } catch (NoSuchItemException e) {
            return null;
        }
    }

    @PutMapping("/setClient/{userId}/{clientId}")
    public ResponseEntity<User> updateClientForUser(@PathVariable("userId") int userId, @PathVariable("clientId") int clientId) {
        try {
            User user = userService.updateClientForUser(userId, clientId);
            return ResponseEntity.ok(user);
        } catch (NoSuchItemException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

package org.mygroup.currencyCalculator.controllers.rest;

import org.mygroup.currencyCalculator.models.userModels.User;
import org.mygroup.currencyCalculator.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * REST Controller for admin_role access.
 *
 * @author  Samvel Ghazaryan
 * @version 1.0
 * */
@RestController
@RequestMapping("/api/v1/admin")
public class AdminRestController {


    private final userService service;

    @Autowired
    public AdminRestController(userService service) {
        this.service = service;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        User user = service.findById(id);

        if (user != null) {
            return new ResponseEntity(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
    }
}

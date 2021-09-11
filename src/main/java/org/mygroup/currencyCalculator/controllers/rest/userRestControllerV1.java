package org.mygroup.currencyCalculator.controllers.rest;

import org.mygroup.currencyCalculator.models.userModels.User;
import org.mygroup.currencyCalculator.services.userService;
import org.mygroup.currencyCalculator.springSecurity.dto.userControllerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * REST Controller for user_role access.
 *
 * @author  Samvel Ghazaryan
 * @version 1.0
 * */
@RestController
@RequestMapping("/api/v1/users/")
public class userRestControllerV1 {

    private final userService service;

    public userRestControllerV1(userService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<userControllerDto> getUserById(@PathVariable("id") Long id) {
        User user = service.findById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        userControllerDto dto = new userControllerDto();
               dto =  dto.makeDtoFrom(user);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}

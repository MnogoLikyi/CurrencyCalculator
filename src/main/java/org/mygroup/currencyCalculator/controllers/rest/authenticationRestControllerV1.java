package org.mygroup.currencyCalculator.controllers.rest;

import org.mygroup.currencyCalculator.models.userModels.User;
import org.mygroup.currencyCalculator.services.userService;
import org.mygroup.currencyCalculator.springSecurity.dto.authenticationRequestDTO;
import org.mygroup.currencyCalculator.springSecurity.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/**
 * Authentication REST controller with Login functionality.
 *
 * @author  Samvel Ghazaryan
 * @version 1.0
 * */
@RestController
@RequestMapping(value = "/api/v1/auth/")
public class authenticationRestControllerV1 {

    private  AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final userService service;


    @Autowired
    public authenticationRestControllerV1(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, userService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.service = userService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody authenticationRequestDTO requestDto) throws IOException, InterruptedException {
        try {
            String username = requestDto.getUsername();

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));

            User user = service.findByUsername(username);

            if (user == null) {
                throw new UsernameNotFoundException("user with username: " + username + " not found");
            }

            String token = jwtTokenProvider.createToken(username, user.getRoles());

            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }
}

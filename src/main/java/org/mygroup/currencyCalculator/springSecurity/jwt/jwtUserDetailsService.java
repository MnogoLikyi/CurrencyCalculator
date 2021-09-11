package org.mygroup.currencyCalculator.springSecurity.jwt;

import org.mygroup.currencyCalculator.models.userModels.User;
import org.mygroup.currencyCalculator.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * This class implements a {@link UserDetailsService } interface and realizes the its functionality of jwt user state.

 @author Samvel Ghazaryan
 @version 1.0
 * */

@Service
public class jwtUserDetailsService implements UserDetailsService {

    private final userService service;

    @Autowired
    public jwtUserDetailsService(userService service) {
        this.service = service;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = service.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }

        jwtUser jwtUser = jwtUserFactory.create(user);
        return jwtUser;
    }
}

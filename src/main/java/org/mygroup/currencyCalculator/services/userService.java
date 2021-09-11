package org.mygroup.currencyCalculator.services;

import org.mygroup.currencyCalculator.models.userModels.User;
import org.mygroup.currencyCalculator.repositories.interfaces.UserRepository;
import org.springframework.stereotype.Service;

/**
 * service API for users database communication.
 *
 * @author Samvel Ghazaryan
 * @version 1.0
 * */

@Service
public class userService {
    private final UserRepository userRepository;

    public userService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username)
    {
        User user =  userRepository.findByUsername(username);

        return user;
    }

    public User findById(Long id)
    {
        return  userRepository.findById(id).get();
    }
}

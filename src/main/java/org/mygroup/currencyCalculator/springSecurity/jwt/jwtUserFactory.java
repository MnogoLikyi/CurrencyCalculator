package org.mygroup.currencyCalculator.springSecurity.jwt;

import org.mygroup.currencyCalculator.models.userModels.Role;
import org.mygroup.currencyCalculator.models.userModels.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class contains a "factory-method" for Jwt user
 *
 * @author Samvel Ghazaryan
 * @version 1.0
 * */

public final class jwtUserFactory {

    public jwtUserFactory() {
    }

    public static jwtUser create(User user) {
        return new jwtUser(
              user.getId(),
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getRoles()),
                user.getStatus(),
                user.getUpdated()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles) {
        return userRoles.stream()
                .map(role ->
                        new SimpleGrantedAuthority(role.getName())
                ).collect(Collectors.toList());
    }
}

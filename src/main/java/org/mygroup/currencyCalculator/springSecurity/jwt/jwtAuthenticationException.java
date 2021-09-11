package org.mygroup.currencyCalculator.springSecurity.jwt;

import org.springframework.security.core.AuthenticationException;
/**
 * Authentication exception for Jwt authentication.
 *
 * @author Samvel Ghazaryan
 * @version 1.0
 * */

public class jwtAuthenticationException extends AuthenticationException {
    public jwtAuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }

    public jwtAuthenticationException(String msg) {
        super(msg);
    }
}

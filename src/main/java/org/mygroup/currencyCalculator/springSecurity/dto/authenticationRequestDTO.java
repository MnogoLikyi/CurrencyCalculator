package org.mygroup.currencyCalculator.springSecurity.dto;

import lombok.Data;
/**
 * service dto class for authentication request username and password saving.
 * @author Samvel Ghazaryan
 * @version 1.0
 * */
@Data
public class authenticationRequestDTO {

    private String username;
    private String password;
}

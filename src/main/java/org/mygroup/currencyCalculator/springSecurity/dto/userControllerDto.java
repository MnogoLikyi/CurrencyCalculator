package org.mygroup.currencyCalculator.springSecurity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.mygroup.currencyCalculator.models.userModels.User;
/**
 * DTO  representation of {@link User} class.
 *
 * @author Samvel Ghazaryan
 * @version 1.0
 * */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class userControllerDto {

    private String name;
    private String lastName;
    private String email;


    public  userControllerDto makeDtoFrom(User user)
    {
        userControllerDto dto = new userControllerDto();
        dto.name = user.getFirstName();
        dto.lastName = user.getLastName();
        dto.email = user.getEmail();

        return dto;
    }

    public User getUser()
    {
        User user = new User();

        user.setFirstName(name);
        user.setLastName(lastName);
        user.setEmail(email);

        return user;
    }
}

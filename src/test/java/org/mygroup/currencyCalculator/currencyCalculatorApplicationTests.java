package org.mygroup.currencyCalculator;

import org.junit.jupiter.api.Test;
import org.mygroup.currencyCalculator.models.userModels.Role;
import org.mygroup.currencyCalculator.models.userModels.User;
import org.mygroup.currencyCalculator.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class currencyCalculatorApplicationTests {
    private final rolesService testRolesService;
    private final userService testUserService;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    currencyCalculatorApplicationTests(org.mygroup.currencyCalculator.services.rolesService testRolesService, org.mygroup.currencyCalculator.services.userService testUserService) {
        this.testRolesService = testRolesService;
        this.testUserService = testUserService;
    }

    @Test
    public void shouldAddTestingRolesAndUsersToDatabaseCurrencycalc() {
        //Create roles
        Role role1 = new Role();
        role1.setName("ROLE_ADMIN");
        Role role2 = new Role();
        role2.setName("ROLE_USER");

        //Add roles to database
        testRolesService.addRole(role1);
        testRolesService.addRole(role2);

        // Create list of roles
        List<Role> roleList = new ArrayList<>();
        roleList.add(role1);
        roleList.add(role2);

        // Create user
        User user1 = new User();
        user1.setFirstName("Samvel");
        user1.setLastName("Ghazaryan");
        user1.setUsername("testusername");
        user1.setEmail("sammuki@mail.ru");
        user1.setPassword(encoder.encode("test"));
        user1.setRoles(roleList);

        //Add user to database
        testUserService.addUser(user1);


    }


    @Test
    void contextLoads() {
    }


}

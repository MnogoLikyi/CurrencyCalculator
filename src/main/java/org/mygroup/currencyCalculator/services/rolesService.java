package org.mygroup.currencyCalculator.services;

import org.mygroup.currencyCalculator.models.userModels.Role;
import org.mygroup.currencyCalculator.repositories.interfaces.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class rolesService {
    private final RolesRepository rolesRepository;

    @Autowired
    public rolesService(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    public void addRole(Role role)
    {
        rolesRepository.save(role);
    }
}

package org.mygroup.currencyCalculator.repositories.interfaces;

import org.mygroup.currencyCalculator.models.userModels.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.Table;

@Repository
public interface RolesRepository extends CrudRepository<Role, Long> {
}

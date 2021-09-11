package org.mygroup.currencyCalculator.repositories.interfaces;

import org.mygroup.currencyCalculator.models.userModels.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Jpa repository for User entity
 *
 * @author Samvel Ghazaryan
 * @version 1.0
 * */

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
     User findByUsername(String username);
}

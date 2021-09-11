package org.mygroup.currencyCalculator.models.userModels;

import lombok.Data;
import javax.persistence.*;
/**
 * Simple domain object that represents application user's role - ADMIN, USER, etc.
 *
 * @author  Samvel Ghazaryan
 * @version 1.0
 * */
@Entity
@Table(name = "roles")
@Data
public class Role extends baseEntity {

    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return "Role{" +
                "id: " + super.getId() + ", " +
                "name: " + name + "}";
    }
}

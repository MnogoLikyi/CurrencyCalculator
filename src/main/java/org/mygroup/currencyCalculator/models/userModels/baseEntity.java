package org.mygroup.currencyCalculator.models.userModels;

import lombok.Data;
import org.mygroup.currencyCalculator.enums.Status;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
/**
 * Base class with property 'id'.
 * Used as a base class for all objects that requires this property.
 *
 * @author Samvel Ghazaryan
 * @version 1.0
 */
@MappedSuperclass
@Data
public class baseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(name = "created")
    private LocalDateTime created;

    @LastModifiedDate
    @Column(name = "updated")
    private LocalDateTime updated;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
}

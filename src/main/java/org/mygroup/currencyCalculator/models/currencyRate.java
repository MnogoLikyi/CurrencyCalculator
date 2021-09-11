package org.mygroup.currencyCalculator.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.mygroup.currencyCalculator.enums.Currency;

import javax.persistence.*;
import java.time.LocalDateTime;
/**
 * this class contains a simple representations of currency exchange members
 * with unique sql constraint for combination of basecurrency and convertingcurrency in database.
 *
 * @author Samvel Ghazaryan
 * @version 1.0
 * */
@Entity
@Table(name = "currency_rate",
        uniqueConstraints = @UniqueConstraint(name = "idx_currency_rate_basecurrency_convertingcurrency",
                columnNames = {"basecurrency","convertingcurrency"}) )
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class currencyRate {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "basecurrency")
    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "convertingcurrency", unique = true)
    private Currency baseCurrency;


    @Column(name = "convertingcurrency")
    @Enumerated(EnumType.STRING)
    private Currency convertingCurrency;

    @Column(name = "exchangerate")
    private double exchangeRate;

    @Column(name = "last_updated")
    private LocalDateTime lastupdated;
}




package org.mygroup.currencyCalculator.repositories.interfaces;

import org.mygroup.currencyCalculator.models.currencyRate;
import org.mygroup.currencyCalculator.enums.Currency;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Jpa repository for currencyRate entity
 *
 * @author Samvel Ghazaryan
 * @version 1.0
 */
@Repository
public interface CurrencyCalcRepository extends CrudRepository<currencyRate, Long> {
    Optional<currencyRate> findByBaseCurrencyAndConvertingCurrency(Currency baseCurrency, Currency convertingCurrency);

}

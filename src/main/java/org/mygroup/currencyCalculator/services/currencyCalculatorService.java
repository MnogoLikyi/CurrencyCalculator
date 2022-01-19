package org.mygroup.currencyCalculator.services;

import org.mygroup.currencyCalculator.helpers.currencyHelper;
import org.mygroup.currencyCalculator.models.currencyRate;
import org.mygroup.currencyCalculator.repositories.interfaces.CurrencyCalcRepository;
import org.mygroup.currencyCalculator.enums.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

/**
 * service API  for currency rates database communication.
 *
 * @author Samvel Ghazaryan
 * @version 1.0
 * */

@Service
public class currencyCalculatorService {

    private final CurrencyCalcRepository repository;

    @Autowired
    public currencyCalculatorService(CurrencyCalcRepository repository) {
        this.repository = repository;
    }

    public void addExchangeVariant(currencyRate variant) {
        repository.save(variant);
    }

    public void addExchangeVariants(ArrayList<currencyRate> currencyRates) {
        this.repository.saveAll(currencyRates);
    }


    public void updateCurrencies() throws IOException, InterruptedException {
        ArrayList<currencyRate> currencyRates = (ArrayList<currencyRate>) currencyHelper.getCurrencyRates();
        if (currencyRates.size() != 0) {
            this.repository.deleteAll();
            addExchangeVariants(currencyRates);
        }
    }

    public currencyRate getCurrencyRate(Currency basecurrency, Currency convertingcurrency) {

       Optional<currencyRate> opt = repository.findByBaseCurrencyAndConvertingCurrency(basecurrency, convertingcurrency);

       if (opt.isEmpty())
       {
        return opt.get();
       }


       return null;
    }

    public LocalDateTime getLastUpdateDate() {

        currencyRate cr = null;
        Optional<currencyRate> optional = repository.findById(1L);

        if (optional != null && !optional.isEmpty()) {
            cr = optional.get();
        return cr.getLastupdated();
        }


        return null;
    }
}

package org.mygroup.currencyCalculator.helpers;

import org.mygroup.currencyCalculator.enums.Currency;
import org.mygroup.currencyCalculator.models.currencyRate;
import org.mygroup.currencyCalculator.services.currencyCalculatorService;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
/**
 * this class contains main operations for currency exchanging.
 *
 * @author  Samvel Ghazaryan
 * @version 1.0
 * */
public class operations {
    private final currencyCalculatorService service;

    public operations(currencyCalculatorService service) {
        this.service = service;
    }
    public static String roundDouble(Double value, String pattern) {
        DecimalFormat decf = new DecimalFormat(pattern);
        return decf.format(value);
    }

    public String exchange(String amount, String baseCurrency, String convertingCurrency) throws IOException, InterruptedException {

        LocalDateTime lastUpdated = service.getLastUpdateDate();
        if (lastUpdated != null) {
            if (LocalDateTime.now().getDayOfYear() - lastUpdated.getDayOfYear() > 10) {
                service.updateCurrencies();
            }
        } else {
            service.updateCurrencies();
        }

        currencyRate crr = service.getCurrencyRate(Enum.valueOf(Currency.class, baseCurrency.toUpperCase()), Enum.valueOf(Currency.class, convertingCurrency.toUpperCase()));
      if (crr != null)
      {
        double rate = crr.getExchangeRate();
        double d = Double.parseDouble(amount);
        double temp = d * rate;
        String formatResult = roundDouble(temp, "#.##");
        return formatResult;
      }
    throw new IllegalArgumentException("Wrong currencies were passed");
    }
}

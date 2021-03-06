package org.mygroup.currencyCalculator.controllers.rest;

import org.mygroup.currencyCalculator.helpers.operations;
import org.mygroup.currencyCalculator.models.userModels.User;
import org.mygroup.currencyCalculator.services.currencyCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
/**
 * Rest controller for currency rate exchange API.
 *
 * @author  Samvel Ghazaryan
 * @version 1.0
 * */
@RestController
@RequestMapping("/api/v1/exchangecalc")
public class CalcRestControllerV1 {

    private final currencyCalculatorService service;

    @Autowired
    public CalcRestControllerV1(currencyCalculatorService service) {
        this.service = service;
    }

    @GetMapping("/exchange/{amount}/{base}/{converting}")
    public ResponseEntity<String> test(
                                       @PathVariable("amount") String amount,
                                       @PathVariable("base") String base,
                                       @PathVariable("converting") String converting
                                       )
            throws IOException, InterruptedException
    {

        operations op = new operations(service);
        String result = op.exchange(amount, base, converting);
        if (result == null) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            service.updateCurrencies();
        }
        
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

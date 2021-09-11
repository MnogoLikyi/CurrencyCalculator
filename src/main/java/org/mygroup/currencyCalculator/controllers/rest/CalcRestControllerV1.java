package org.mygroup.currencyCalculator.controllers.rest;

import org.mygroup.currencyCalculator.helpers.operations;
import org.mygroup.currencyCalculator.services.currencyCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public ResponseEntity<String> test(@PathVariable("base") String base,
                                       @PathVariable("amount") String amount,
                                       @PathVariable("converting") String converting)
            throws IOException, InterruptedException
    {
        operations op = new operations(service);

        String result = op.exchange(amount, base, converting);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);

    }
}

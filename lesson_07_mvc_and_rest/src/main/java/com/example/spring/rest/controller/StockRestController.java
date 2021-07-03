package com.example.spring.rest.controller;


import com.example.spring.rest.exception.handling.StockError;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import org.springframework.http.MediaType;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;

@RestController
//@RequestMapping(value="/rest", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@RequestMapping(value="/rest", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class StockRestController {

    @Value
    @AllArgsConstructor
    static class Stock {

        @NonNull
        @Size(max=15)
        String company;

        @NonNull
        @DecimalMin("0.01")
        Double price;

    }

    private static final Map<String, Stock> STOCK_CATALOG = new HashMap<String, Stock>() {
        {
            put("NASDAQ:AAPL", new Stock("NASDAQ:AAPL", 155.45));
            put("NASDAQ:GOOG", new Stock("NASDAQ:GOOG", 975.63));
            put("NASDAQ:AMZN", new Stock("NASDAQ:AMZN", 1006.73));
        }
    };

    @GetMapping("/stock/{company}")
    public Stock getInfo(@PathVariable("company") String copmany) {

        Stock stock;
        if (STOCK_CATALOG.containsKey(copmany)) {
            stock = STOCK_CATALOG.get(copmany);
        } else {
            throw new IllegalStateException("Sorry we do not have stock information for given company");
        }

        return stock;
    }

    @PutMapping("/stock/{company}")
    public void storeInfo(@PathVariable("company") String company, @Valid @RequestBody Stock stock) {
        validateRequest(company);
        STOCK_CATALOG.put(company, stock);
    }

    @PostMapping("/stock/{company}")
    public void updateInfo(@PathVariable("company") String company, @Validated @RequestBody Stock stock) {
        STOCK_CATALOG.put(company, stock);
    }

    @ExceptionHandler(IllegalStateException.class)
    public StockError handleException(IllegalStateException exception) {
        return new StockError( "00101", exception.getMessage());
    }

    private void validateRequest(String company) {
        if (company.matches("\\d+")) {
            throw new IllegalArgumentException("Company stock can only contains digits");
        }
    }

}

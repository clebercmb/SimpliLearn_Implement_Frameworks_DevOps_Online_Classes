package com.example.spring.data.access.controller;


import com.example.spring.data.access.dao.StockDao;
import com.example.spring.data.access.dto.Stock;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class StockDataAwareController {

    @Resource
    @Qualifier("jpa")
    private StockDao stockDao;

    @GetMapping("/stock/{id}")
    public Stock getInfo(@PathVariable("id") String id) {
        Stock stock = stockDao.findById(id);
        if (stock == null) {
            throw new IllegalStateException("Sorry we do not have stock information for given company");
        }

        return stock;
    }

    @PutMapping("/stock/{id}")
    public void saveStock(@PathVariable("id") String id, @RequestBody Stock stock) {
        stockDao.save(stock);
    }

}

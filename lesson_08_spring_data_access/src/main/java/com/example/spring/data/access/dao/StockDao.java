package com.example.spring.data.access.dao;

import com.example.spring.data.access.dto.Stock;

public interface StockDao {
    Stock findById(String id);
    void save(Stock stock);
}

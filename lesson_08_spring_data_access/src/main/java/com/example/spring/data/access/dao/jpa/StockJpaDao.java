package com.example.spring.data.access.dao.jpa;

import com.example.spring.data.access.dao.StockDao;
import com.example.spring.data.access.dto.Stock;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
@Qualifier("jpa")
public class StockJpaDao implements StockDao {

    @Resource
    private StockJpaRepository stockJpaRepository;

    @Resource
    private StockJpaMapper stockJpaMapper;

    @Override
    public Stock findById(String id) {
        return stockJpaRepository.findByNameIgnoreCaseStartingWith(id)
                .map(stockEntity -> stockJpaMapper.toDto(stockEntity))
                .orElse(null);
    }

    @Override
    public void save(Stock stock) {
        stockJpaRepository.save(stockJpaMapper.toEntity(stock));
    }
}

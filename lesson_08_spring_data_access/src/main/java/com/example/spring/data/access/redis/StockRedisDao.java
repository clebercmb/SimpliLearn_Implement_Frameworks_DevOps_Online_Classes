package com.example.spring.data.access.redis;

import com.example.spring.data.access.dao.StockDao;
import com.example.spring.data.access.dto.Stock;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
@Qualifier("redis")
public class StockRedisDao implements StockDao {

    @Resource
    private StockRedisRepository stockRedisRepository;

    @Resource
    private StockRedisMapper stockRedisMapper;

    @Override
    public Stock findById(String id) {
        return stockRedisRepository.findById(id)
                .map(stockEntity -> stockRedisMapper.toDto(stockEntity))
                .orElse(null);
    }

    @Override
    public void save(Stock stock) {
        stockRedisRepository.save(stockRedisMapper.toEntity(stock));
    }
}

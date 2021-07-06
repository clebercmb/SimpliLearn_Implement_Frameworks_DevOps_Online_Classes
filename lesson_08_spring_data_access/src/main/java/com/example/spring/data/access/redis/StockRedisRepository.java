package com.example.spring.data.access.redis;

import org.springframework.data.repository.CrudRepository;

public interface StockRedisRepository extends CrudRepository<Stock, String> {
}

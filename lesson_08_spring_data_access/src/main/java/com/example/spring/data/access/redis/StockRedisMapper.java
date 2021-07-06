package com.example.spring.data.access.redis;

import org.mapstruct.Mapper;

@Mapper
public interface StockRedisMapper {
    Stock toEntity(com.example.spring.data.access.dto.Stock stock);

    com.example.spring.data.access.dto.Stock toDto(Stock stock);
}

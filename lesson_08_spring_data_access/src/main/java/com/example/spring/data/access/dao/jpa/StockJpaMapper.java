package com.example.spring.data.access.dao.jpa;


import org.mapstruct.Mapper;

@Mapper
public interface StockJpaMapper {
    Stock toEntity(com.example.spring.data.access.dto.Stock stock);

    com.example.spring.data.access.dto.Stock toDto(Stock stock);

}

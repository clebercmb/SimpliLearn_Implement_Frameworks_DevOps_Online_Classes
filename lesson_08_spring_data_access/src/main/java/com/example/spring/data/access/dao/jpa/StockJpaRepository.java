package com.example.spring.data.access.dao.jpa;


import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StockJpaRepository extends CrudRepository<Stock, String> {


    Optional<Stock> findByNameIgnoreCaseStartingWith(String name);
}

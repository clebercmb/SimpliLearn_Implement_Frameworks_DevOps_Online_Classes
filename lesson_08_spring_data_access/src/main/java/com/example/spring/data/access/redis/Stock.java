package com.example.spring.data.access.redis;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@Data
@RedisHash
public class Stock {
    @Id
    private String id;
    private String name;
    private Double price;
}

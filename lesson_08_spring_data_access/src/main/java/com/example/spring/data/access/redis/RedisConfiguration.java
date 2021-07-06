package com.example.spring.data.access.redis;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

@Configuration
@EnableRedisRepositories
public class RedisConfiguration {
    private final RedisServer redisServer;

    public RedisConfiguration(RedisProperties redisProperties) {
        this.redisServer = new RedisServer(redisProperties.getRedisPort());
    }

    @Bean
    public StockRedisMapper stockRedisMapper() {
        return Mappers.getMapper(StockRedisMapper.class);
    }

    @PostConstruct
    public void startEmbeddedRedisServer() throws IOException {
        redisServer.start();
    }

    @PreDestroy
    public void stopEmbeddedRedisServer() throws IOException {
        redisServer.stop();
    }

}

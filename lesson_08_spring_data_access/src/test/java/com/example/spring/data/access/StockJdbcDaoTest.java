package com.example.spring.data.access;

import com.example.spring.data.access.dao.StockDao;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.BootstrapWith;
import org.springframework.util.Assert;

import javax.annotation.Resource;

@SpringBootTest
@BootstrapWith(SpringBootTestContextBootstrapper.class)
public class StockJdbcDaoTest {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private StockDao stockDao;

    @Test
    void shouldFindExistingStock() {
        Assert.notNull(stockDao.findById("NASDAQ:AAPL"));
    }


}

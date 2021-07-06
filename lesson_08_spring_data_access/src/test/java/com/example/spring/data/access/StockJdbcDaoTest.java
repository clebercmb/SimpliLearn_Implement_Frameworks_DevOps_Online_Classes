package com.example.spring.data.access;

import com.example.spring.data.access.dao.StockDao;

import com.example.spring.data.access.dto.Stock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.util.Assert;

import javax.annotation.Resource;

@SpringTestSupport
@BootstrapWith(SpringBootTestContextBootstrapper.class)
public class StockJdbcDaoTest {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    @Qualifier("jdbc")
    private StockDao stockDao;

    @Test
    void shouldFindExistingStock() {

        Assertions.assertNotNull(stockDao.findById("NASDAQ:AAPL"));
    }

    @Test
    void shouldCreateStock() throws Exception {
        int stocksNumBefore = retrieveStocksNum();
        Stock stock = new Stock();
        stock.setId("NASDAQ:FB");
        stock.setName("Facebook Inc.");
        stock.setPrice(135.5);
        stockDao.save(stock);
        int stocksNumAfter = retrieveStocksNum();
        Assertions.assertTrue(stocksNumBefore < stocksNumAfter);

    }

    @AfterTransaction
    void shouldCountInitialNumberOfStocks() throws Exception {
        int stocksNum = retrieveStocksNum();
        Assertions.assertEquals(stocksNum, 3);
        System.out.printf("Number of rows verified %s\n", stocksNum);
    }

    private int retrieveStocksNum() {
        return JdbcTestUtils.countRowsInTable(jdbcTemplate, "stocks");
    }
}

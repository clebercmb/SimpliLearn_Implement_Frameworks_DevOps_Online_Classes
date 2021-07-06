package com.example.spring.data.access;

import com.example.spring.data.access.controller.StockDataAwareController;
import com.example.spring.data.access.dao.StockDao;
import com.example.spring.data.access.dto.Stock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.util.AssertionErrors;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.NestedServletException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringTestSupport
@BootstrapWith(SpringBootTestContextBootstrapper.class)
public class StockDataAwareControllerStandAloneTest {

    private MockMvc mockMvc;

    private StockDao stockDao;


    @BeforeEach
    void setup() {
        stockDao = Mockito.mock(StockDao.class);
        StockDataAwareController stockDataAwareController = new StockDataAwareController(stockDao);

        this.mockMvc = MockMvcBuilders.standaloneSetup(stockDataAwareController).build();
    }

    @Test
    void shouldGetStockById() throws Exception {
        String stockId = "NASDAQ:GOOG";
        Stock stock = new Stock();
        stock.setId(stockId);
        stock.setName("Alphabet Inc.");
        stock.setPrice(975.63);
        stockDao.findById(stockId);

        when(stockDao.findById(stockId)).thenReturn(stock);

        mockMvc.perform( get("/stock/{id}", stockId) ).andExpect(status().isOk());

    }

    @Test
    void shouldHandleAbsentGetStockById() throws Exception {
        Throwable exception = assertThrows(NestedServletException.class, () -> {
            mockMvc.perform(get("/stock/{id}", "NASDAQ:GOOG")).andExpect(status().isOk());
        });

        assertTrue(exception.getMessage().contains("Sorry we do not have stock information for given company"));
    }

}

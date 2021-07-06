package com.example.spring.data.access;


import com.example.spring.data.access.controller.StockDataAwareController;
import com.example.spring.data.access.dto.Stock;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.http.MediaType.*;

@SpringJUnitConfig
@SpringBootTest
public class StockDataAwareControllerWebContextTest {

    @Autowired
    private WebApplicationContext wac;

    @Resource
    private ObjectMapper objectMapper;

    private MockMvc mockMvc;

    @Autowired
    private StockDataAwareController stockDataAwareController;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    void shouldGetStockById() throws Exception {
        String stockId = "NASDAQ:GOOG";
        mockMvc.perform(get("/stock/{id}", stockId)).andExpect(status().isOk());
    }

    @Test
    void shouldCreateStock() throws Exception {
        String stockId = "NASDAQ:GOOG";
        Stock stock = new Stock();
        stock.setId("NASDAQ:FB");
        stock.setName("Facebook Inc.");
        stock.setPrice(135.5);

        String stockAsJason = objectMapper.writeValueAsString(stock);
        mockMvc.perform(put("/stock/{id}", stockId)
                .contentType(APPLICATION_JSON)
                .content(stockAsJason))
                .andExpect(status().isOk());
    }


}



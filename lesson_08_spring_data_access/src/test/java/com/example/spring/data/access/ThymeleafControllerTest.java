package com.example.spring.data.access;

import com.gargoylesoftware.htmlunit.WebClient;
import org.hamcrest.core.StringContains;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.http.MediaType.*;


@SpringJUnitWebConfig
@SpringBootTest
public class ThymeleafControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    private WebClient webClient;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        webClient = MockMvcWebClientBuilder.webAppContextSetup(wac).build();
    }

    @Test
    void shouldRenderView() throws Exception {

        MockHttpServletRequestBuilder ver =  get("/mvc/view");
        mockMvc.perform(get("/mvc/view"))
                .andExpect(status().isOk())
                .andExpect(xpath("//strong/text()").string(new StringContains("Thymeleaf")));
    }
}

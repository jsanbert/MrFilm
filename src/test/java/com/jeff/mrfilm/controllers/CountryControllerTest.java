package com.jeff.mrfilm.controllers;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CountryControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        DefaultMockMvcBuilder defaultBuilder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = defaultBuilder.build();
    }

    @Test
    public void whenAddCountry_withCorrectContent_thenReturnOKAndPrintCountry() throws Exception {
        String content = "{" + "\"name\": \"Dubai\",\"code\": \"DB\"}";
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/api/v1/countries/add").contentType(MediaType.APPLICATION_JSON).content(content);
        this.mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @After(value = "whenAddCountry_withCorrectContent_thenReturnOKAndPrintCountry")
    public void checkCountryHasBeenSuccessfullyAdded() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/api/v1/countries/").contentType(MediaType.APPLICATION_JSON);
        MvcResult result = this.mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();
        String content = result.getResponse().getContentAsString();
        assertTrue(content.contains("Dubai"));
    }

    @Test
    public void whenAddCountry_withIncorrectContent_thenReturnBadRequestAndPrintError() throws Exception {
        String content = "{" + "\"name\": \"Ireland\"}";
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/api/v1/countries/add").contentType(MediaType.APPLICATION_JSON).content(content);
        this.mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isBadRequest()).andDo(MockMvcResultHandlers.print());
    }
}
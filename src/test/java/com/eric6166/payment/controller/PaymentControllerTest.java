package com.eric6166.payment.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(PaymentController.class)
class PaymentControllerTest {

    private static final String PATH = "/payment";
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        // default implementation ignored
    }

    @AfterEach
    void tearDown() {
        // default implementation ignored
    }

    @Test
    void ping() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(PATH + "/ping"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("pong"));
    }
}
package com.alan.api.controller;

import com.alan.springbootapi.ApplicationTest;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

/**
 * author: alan.peng
 * description:
 * date: create in 13:24 2018/11/12
 * modified By：
 */
@Transactional
@Rollback
public abstract class BaseControllerTest extends ApplicationTest {

    @Autowired
    private WebApplicationContext context;

    @Value("${server.port}")
    private int port;

    final String url = "http://localhost:" + this.port;

    MockMvc mockMvc;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }
}

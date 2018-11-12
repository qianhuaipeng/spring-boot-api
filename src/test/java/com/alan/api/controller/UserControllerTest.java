package com.alan.api.controller;

import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * author: alan.peng
 * description:
 * date: create in 11:03 2018/11/12
 * modified By：
 */
public class UserControllerTest extends BaseControllerTest {

    private final String resource = "/user";

    @Test(timeout = 5000)
    public void login() throws Exception {
        String user = "{\"username\":\"admin\", \"password\":\"admin123\"}";
        this.mockMvc.perform(
                post(this.url + this.resource + "/login")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(user)
                        .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andReturn();
    }
}

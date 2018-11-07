package com.alan.api.core.jwt;

import com.alan.api.core.Response.ResultGenerator;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;

/**
 * author: alan.peng
 * description:
 * date: create in 13:23 2018/11/7
 * modified By：
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable{
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setHeader("Content-type", MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
        response.getWriter().print(ResultGenerator.genUnauthorizedResult().toString());
        response.getWriter().close();
    }
}

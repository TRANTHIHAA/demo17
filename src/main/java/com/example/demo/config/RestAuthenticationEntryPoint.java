package com.example.demo.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint  {
    @Override
    public void commence(HttpServletRequest request,
                       HttpServletResponse response,
                       AuthenticationException accessDeniedException)
            throws IOException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getWriter().write("Access Denied!");
    }
}

package com.example.lab3.filters;

import org.springframework.stereotype.Component;

import java.io.IOException;

import javax.servlet.*;


@Component
public class TestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }
}

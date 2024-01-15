package com.czc.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@WebFilter("/name")
@Component
public class NameFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("NameFilter do Filter");
        chain.doFilter(request , response);
    }

    @Override
    public void destroy() {

//        Filter.super.destroy();
    }
}

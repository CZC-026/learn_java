package com.czc.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class UserInfoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("UserInfoFilter: doFilter");
        //do others
        filterChain.doFilter(servletRequest , servletResponse);
    }

    @Override
    public void destroy() {
//        Filter.super.destroy();
    }
}

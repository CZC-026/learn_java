package com.czc.config;

import com.czc.filter.UserInfoFilter;
import jakarta.servlet.FilterRegistration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<UserInfoFilter> filterFilterRegistrationBean(){
        FilterRegistrationBean<UserInfoFilter> userInfoFilterFilterRegistrationBean = new FilterRegistrationBean<>(new UserInfoFilter());
        userInfoFilterFilterRegistrationBean.addUrlPatterns("/user/info");
        return userInfoFilterFilterRegistrationBean;
    }
}

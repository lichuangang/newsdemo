package com.msxf.tool.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by chuangang.li on 2017/2/7.
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
//    @Override 自定义拦截器
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 多个拦截器组成一个拦截器链
//        // addPathPatterns 用于添加拦截规则
//        // excludePathPatterns 用户排除拦截
//        registry.addInterceptor(new ErrorInterceptor()).addPathPatterns("/**");
//        super.addInterceptors(registry);
//    }

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/error").setViewName("error.html");
//        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//    }

    /**
     * 静态页面访问
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        super.configurePathMatch(configurer);
        configurer.setUseSuffixPatternMatch(false);
    }
}

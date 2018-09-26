package com.gioov.spiny.common.interceptor;

import com.gioov.spiny.common.constant.Api;
import com.gioov.spiny.common.constant.Page;
import com.gioov.spiny.common.constant.Url;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebMvcConfiguration.class);

    @Bean
    public WebInterceptor webInterceptor() {
        return new WebInterceptor();
    }

    @Bean
    public ApiInterceptor apiInterceptor() {
        return new ApiInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // WebInterceptor
        registry.addInterceptor(webInterceptor())
                .addPathPatterns(Url.ALL_PATH_PATTERN)
                .excludePathPatterns(Page.STATIC);

        // ApiInterceptor
        registry.addInterceptor(apiInterceptor())
                .addPathPatterns(Api.API_PATH_PATTERN).excludePathPatterns(Page.STATIC);


    }

}

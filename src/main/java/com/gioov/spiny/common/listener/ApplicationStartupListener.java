package com.gioov.spiny.common.listener;

import com.gioov.common.web.http.BaseResponse;
import com.gioov.spiny.common.property.AppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@Service
public class ApplicationStartupListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationStartupListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        AutowireCapableBeanFactory factory = event.getApplicationContext().getAutowireCapableBeanFactory();
        AppProperties appProperties = factory.getBean(AppProperties.class);

        Map<String, Object> config = BaseResponse.config;
        config.put("showException", appProperties.getDebug());
        config.put("timeZone", appProperties.getDefaultTimeZone());
        config.put("dateFormat", appProperties.getDefaultDateFormat());
    }

}

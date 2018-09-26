package com.gioov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@SpringBootApplication
public class SpinyApplication extends SpringBootServletInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpinyApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpinyApplication.class, args);

        LOGGER.info("==================={}===================", "程序启动成功！");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpinyApplication.class);
    }

}

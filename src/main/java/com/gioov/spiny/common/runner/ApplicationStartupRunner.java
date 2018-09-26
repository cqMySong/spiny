package com.gioov.spiny.common.runner;

import com.gioov.spiny.system.service.DictionaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@Component
@Order
public class ApplicationStartupRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationStartupRunner.class);

    @Autowired
    private DictionaryService dictionaryService;

    @Override
    public void run(String... strings) throws Exception {

        // 首次启动加载数据字典到 ServletContext 内存
        dictionaryService.addDictionaryToServletContext();

    }
}

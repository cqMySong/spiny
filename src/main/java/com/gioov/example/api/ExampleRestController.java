package com.gioov.example.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@RestController
@RequestMapping("/api/example")
public class ExampleRestController {

    /**
     * 测试 API
     *
     * @return String
     */
    @RequestMapping("/test")
    public String test() {
        return "Example api test.";
    }
}

package com.hazer.gyo.hazer.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>描述</p>
 *
 * @author hazer
 * @version 1.0
 * @date 2020-09-18
 */
@RestController
public class TestController {
    @RequestMapping("test")
    public void testController(@RequestParam String s) {
        System.out.printf(s);
    }
}

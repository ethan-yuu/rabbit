package org.ethan.rabbit.client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Describe：
 *
 * @Author： ethan-yuu
 * @Date： 2024/11/22 10:54
 */
@RestController
public class TestController {

    @RequestMapping(value = "/hhh", method = RequestMethod.GET)
    public void test() {
        System.out.println("hhhhhhhh");
    }

}

package com.jeeno.springbootlogin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 系統首頁
 * @author Jeeno
 * @version 0.0.1
 * @date 2019/12/19 14:17
 */
@Slf4j
@Controller
public class IndexController {

    /**
     * 访问首页
     *
     * @return index
     */
    @GetMapping({"", "/index"})
    public String index() {
        return "/index";
    }

}

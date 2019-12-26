package com.ustc.travelbook.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liuwang
 * @date 2019/12/26 15:39
 */
@Slf4j
@Controller
public class IndexController {

    @GetMapping("index")
    public String index() {
        log.info("go to index page...");
        return "index";
    }

}

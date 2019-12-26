package com.ustc.travelbook.controller;

import com.ustc.travelbook.service.ICustomerService;
import com.ustc.travelbook.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author liuwang
 * @date 2019/12/26 13:33
 */
@Controller
public class AbstractController {
    @Autowired
    ICustomerService customerService;
}

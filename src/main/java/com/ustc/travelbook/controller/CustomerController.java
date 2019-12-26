package com.ustc.travelbook.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

/**
 * @author liuwang
 * @date 2019/12/26 13:33
 */
@Slf4j
@Controller
@RequestMapping("customer")
public class CustomerController extends AbstractController {

    @ResponseBody
    @PostMapping(value = "insert")
    public String insert(@RequestParam(value = "customerName") @NotBlank(message = "姓名不能为空") String customerName) {
        customerService.insertCustomer(customerName);
        return "success";
    }

    @GetMapping(value = "page")
    public String insert() {
        log.info("jump to customer_manage.html .....");
        return "customer_manage";
    }
}

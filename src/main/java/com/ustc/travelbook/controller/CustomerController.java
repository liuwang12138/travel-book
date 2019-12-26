package com.ustc.travelbook.controller;

import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

/**
 * @author liuwang
 * @date 2019/12/26 13:33
 */
@RequestMapping("customer")
public class CustomerController extends AbstractController {

    @ResponseBody
    @PostMapping(value = "insert")
    public String insert(@RequestParam(value = "customerName") @NotBlank(message = "姓名不能为空") String customerName) {
        customerService.insertCustomer(customerName);
        return "success";
    }

}

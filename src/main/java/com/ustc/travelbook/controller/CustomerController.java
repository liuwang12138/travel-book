package com.ustc.travelbook.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ustc.travelbook.dto.ResultMessage;
import com.ustc.travelbook.po.CustomerPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author shanjizhong
 * @date 2019/12/26 13:33
 */
@Slf4j
@RestController
@RequestMapping("customer")
public class CustomerController extends AbstractController {

    @PostMapping(value = "insert")
    public ResultMessage insert(@RequestParam(value = "customerName") @NotBlank(message = "姓名不能为空") String customerName) {
        customerService.insertCustomer(customerName);
        return ResultMessage.success();
    }

    @PostMapping(value = "list/all")
    public Page<CustomerPO> selectAll(@RequestParam(value = "pageNum", required = false, defaultValue = "0") @Min(1) Integer pageNum,
                                      @RequestParam(value = "pageSize", required = false, defaultValue = "0") @Min(1) Integer pageSize) {
        return customerService.selectByPage(pageNum, pageSize);
    }

    @PostMapping(value = "delete")
    public ResultMessage deleteById(@RequestParam(value = "id") Integer id) {
        log.info("delete method............");
        if (customerService.deleteById(id)) {
            return ResultMessage.success();
        }
        return ResultMessage.failed();
    }
}

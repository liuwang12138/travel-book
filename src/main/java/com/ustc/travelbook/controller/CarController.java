package com.ustc.travelbook.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ustc.travelbook.dto.ResultMessage;
import com.ustc.travelbook.po.CarPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author shanjizhong
 * @date 2019/12/27 14:41
 */
@Slf4j
@RestController
@RequestMapping("car")
public class CarController extends AbstractController {

    @PostMapping(value = "insert")
    public ResultMessage insert(CarPO carPo) {
        try {
            carService.insertCar(carPo);
            return ResultMessage.success();
        } catch (Exception e) {
            return ResultMessage.failed(e.getMessage());
        }
    }

    @PostMapping(value = "list/all")
    public Page<CarPO> selectAll(@RequestParam(value = "pageNum", required = false, defaultValue = "0") Integer pageNum,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize) {
        return carService.selectByPage(pageNum, pageSize);
    }

    @PostMapping(value = "delete")
    public ResultMessage deleteById(@RequestParam(value = "id") Integer id) {
        log.info("delete method............");
        if (carService.deleteById(id)) {
            return ResultMessage.success();
        }
        return ResultMessage.failed();
    }

}

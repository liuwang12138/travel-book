package com.ustc.travelbook.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ustc.travelbook.dto.ResultMessage;
import com.ustc.travelbook.po.FlightPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author shanjizhong
 * @date 2019/12/27 11:46
 */
@Slf4j
@RestController
@RequestMapping("flight")
public class FlightController extends AbstractController {

    @PostMapping(value = "insert")
    public ResultMessage insert(FlightPO flightPo) {
        try {
            flightService.insertFlight(flightPo);
            return ResultMessage.success();
        } catch (Exception e) {
            return ResultMessage.failed(e.getMessage());
        }
    }

    @PostMapping(value = "list/all")
    public IPage<FlightPO> selectAll(@RequestParam(value = "pageNum", required = false, defaultValue = "0") Integer pageNum,
                           @RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize) {
        return flightService.selectByPage(pageNum, pageSize);
    }

    @PostMapping(value = "delete")
    public ResultMessage deleteById(@RequestParam(value = "id") Integer id) {
        log.info("delete method............");
        if (flightService.deleteById(id)) {
            return ResultMessage.success();
        }
        return ResultMessage.failed();
    }

}

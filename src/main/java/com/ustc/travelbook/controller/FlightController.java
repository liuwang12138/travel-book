package com.ustc.travelbook.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ustc.travelbook.dto.ResultMessage;
import com.ustc.travelbook.dto.TravelPathDTO;
import com.ustc.travelbook.po.CustomerPO;
import com.ustc.travelbook.po.FlightPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author shanjizhong
 * @date 2019/12/27 11:46
 */
@Slf4j
@Controller
@RequestMapping("flight")
public class FlightController extends AbstractController {

    @ResponseBody
    @PostMapping(value = "insert")
    public ResultMessage insert(FlightPO flightPo) {
        try {
            flightService.insertFlight(flightPo);
            return ResultMessage.success();
        } catch (Exception e) {
            return ResultMessage.failed(e.getMessage());
        }
    }

    @GetMapping(value = "list/all")
    public String selectAll(@RequestParam(value = "pageNum", required = false, defaultValue = "0") Integer pageNum,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize,
                            Model model) {
        Page<FlightPO> flightPoPage = flightService.selectByPage(pageNum, pageSize);
        model.addAttribute("flightInfo", flightPoPage);

        return "flight_manage";
    }

    @PostMapping(value = "delete")
    @ResponseBody
    public ResultMessage deleteById(@RequestParam(value = "id") Integer id) {
        log.info("delete method............");
        if (flightService.deleteById(id)) {
            return ResultMessage.success();
        }
        return ResultMessage.failed();
    }

}

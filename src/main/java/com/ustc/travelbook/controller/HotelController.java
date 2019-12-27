package com.ustc.travelbook.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ustc.travelbook.dto.ResultMessage;
import com.ustc.travelbook.po.FlightPO;
import com.ustc.travelbook.po.HotelPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author shanjizhong
 * @date 2019/12/27 14:42
 */
@Slf4j
@Controller
@RequestMapping("hotel")
public class HotelController extends AbstractController {

    @ResponseBody
    @PostMapping(value = "insert")
    public ResultMessage insert(HotelPO hotelPo) {
        try {
            hotelService.insertHotel(hotelPo);
            return ResultMessage.success();
        } catch (Exception e) {
            return ResultMessage.failed(e.getMessage());
        }
    }

    @GetMapping(value = "list/all")
    public String selectAll(@RequestParam(value = "pageNum", required = false, defaultValue = "0") Integer pageNum,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize,
                            Model model) {
        Page<HotelPO> hotelPoPage = hotelService.selectByPage(pageNum, pageSize);
        model.addAttribute("hotelInfo", hotelPoPage);

        return "hotel_manage";
    }

    @PostMapping(value = "delete")
    @ResponseBody
    public ResultMessage deleteById(@RequestParam(value = "id") Integer id) {
        log.info("delete method............");
        if (hotelService.deleteById(id)) {
            return ResultMessage.success();
        }
        return ResultMessage.failed();
    }

}
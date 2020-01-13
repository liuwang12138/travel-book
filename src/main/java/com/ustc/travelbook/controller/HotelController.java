package com.ustc.travelbook.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ustc.travelbook.dto.ResultMessage;
import com.ustc.travelbook.po.HotelPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author shanjizhong
 * @date 2019/12/27 14:42
 */
@Slf4j
@RestController
@RequestMapping("hotel")
public class HotelController extends AbstractController {

    @PostMapping(value = "insert")
    public ResultMessage insert(HotelPO hotelPo) {
        try {
            hotelService.insertHotel(hotelPo);
            return ResultMessage.success();
        } catch (Exception e) {
            return ResultMessage.failed(e.getMessage());
        }
    }

    @PostMapping(value = "list/all")
    public IPage<HotelPO> selectAll(@RequestParam(value = "pageNum", required = false, defaultValue = "0") Integer pageNum,
                                    @RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize) {
        return hotelService.selectByPage(pageNum, pageSize);
    }

    @PostMapping(value = "delete")
    public ResultMessage deleteById(@RequestParam(value = "id") Integer id) {
        log.info("delete method............");
        if (hotelService.deleteById(id)) {
            return ResultMessage.success();
        }
        return ResultMessage.failed();
    }

}

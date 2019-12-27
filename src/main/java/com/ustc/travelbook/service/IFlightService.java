package com.ustc.travelbook.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ustc.travelbook.po.CustomerPO;
import com.ustc.travelbook.po.FlightPO;

import java.math.BigDecimal;

/**
 * @author shanjizhong
 * @date 2019/12/27 11:49:40
 */
public interface IFlightService {

    void insertFlight(FlightPO po) throws Exception;

    Page<FlightPO> selectByPage(Integer pageNum, Integer pageSize);

    Boolean deleteById(Integer id);

}

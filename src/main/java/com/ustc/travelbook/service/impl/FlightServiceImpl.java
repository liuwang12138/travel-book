package com.ustc.travelbook.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ustc.travelbook.dao.FlightDao;
import com.ustc.travelbook.po.CustomerPO;
import com.ustc.travelbook.po.FlightPO;
import com.ustc.travelbook.service.IFlightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author shanjizhong
 * @date 2019/12/27 11:50
 */

@Slf4j
@Service
public class FlightServiceImpl implements IFlightService {

    @Autowired
    FlightDao flightDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertFlight(FlightPO po) throws Exception {
        log.info("insert po : " + po);
        flightDao.insert(po);
    }

    @Override
    public Page<FlightPO> selectByPage(Integer pageNum, Integer pageSize) {
        Page<FlightPO> page = new Page<>(1, Integer.MAX_VALUE);
        if (pageNum > 0 && pageSize > 0) {
            page = new Page<>(pageNum, pageSize);
        }

        return flightDao.selectPage(page, null);
    }

    @Override
    public Boolean deleteById(Integer id) {
        return flightDao.deleteById(id) > 0;
    }
}

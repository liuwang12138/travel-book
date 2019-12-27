package com.ustc.travelbook.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ustc.travelbook.dao.CarDao;
import com.ustc.travelbook.dao.FlightDao;
import com.ustc.travelbook.po.CarPO;
import com.ustc.travelbook.po.FlightPO;
import com.ustc.travelbook.service.ICarService;
import com.ustc.travelbook.service.IFlightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author shanjizhong
 * @date 2019/12/27 11:50
 */

@Slf4j
@Service
public class CarServiceImpl implements ICarService {

    @Autowired
    CarDao carDao;

    @Override
    public void insertCar(CarPO po) throws Exception {
        log.info("insert po : " + po);
        carDao.insert(po);
    }

    @Override
    public Page<CarPO> selectByPage(Integer pageNum, Integer pageSize) {
        Page<CarPO> page = new Page<>(1, Integer.MAX_VALUE);
        if (pageNum > 0 && pageSize > 0) {
            page = new Page<>(pageNum, pageSize);
        }

        return carDao.selectPage(page, null);
    }

    @Override
    public Boolean deleteById(Integer id) {
        return carDao.deleteById(id) > 0;
    }
}

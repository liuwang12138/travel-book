package com.ustc.travelbook.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ustc.travelbook.dao.FlightDao;
import com.ustc.travelbook.dao.HotelDao;
import com.ustc.travelbook.po.FlightPO;
import com.ustc.travelbook.po.HotelPO;
import com.ustc.travelbook.service.IFlightService;
import com.ustc.travelbook.service.IHotelService;
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
public class HotelServiceImpl implements IHotelService {

    @Autowired
    HotelDao hotelDao;

    @Override
    public void insertHotel(HotelPO po) throws Exception {
        log.info("insert po : " + po);
        hotelDao.insert(po);
    }

    @Override
    public Page<HotelPO> selectByPage(Integer pageNum, Integer pageSize) {
        Page<HotelPO> page = new Page<>(1, Integer.MAX_VALUE);
        if (pageNum > 0 && pageSize > 0) {
            page = new Page<>(pageNum, pageSize);
        }

        return hotelDao.selectPage(page, null);
    }

    @Override
    public Boolean deleteById(Integer id) {
        return hotelDao.deleteById(id) > 0;
    }
}

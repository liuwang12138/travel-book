package com.ustc.travelbook.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ustc.travelbook.dao.ReservationDao;
import com.ustc.travelbook.dto.CarReservationDTO;
import com.ustc.travelbook.dto.FlightReservationDTO;
import com.ustc.travelbook.dto.HotelReservationDTO;
import com.ustc.travelbook.service.IReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shanjizhong
 * @date 2019/12/27 16:54
 */
@Slf4j
@Service
public class ReservationServiceImpl implements IReservationService {

    @Autowired
    ReservationDao reservationDao;

    @Override
    public IPage<FlightReservationDTO> selectFlightReservationInfoByPage(Integer pageNum, Integer pageSize, Integer customerId) {
        Page<FlightReservationDTO> page = new Page<>(1, Integer.MAX_VALUE);
        if (pageNum > 0 && pageSize > 0) {
            page = new Page<>(pageNum, pageSize);
        }

        return reservationDao.selectFlightReservationInfo(page, customerId);
    }

    @Override
    public IPage<HotelReservationDTO> selectHotelReservationInfoByPage(Integer pageNum, Integer pageSize, Integer customerId) {
        Page<HotelReservationDTO> page = new Page<>(1, Integer.MAX_VALUE);
        if (pageNum > 0 && pageSize > 0) {
            page = new Page<>(pageNum, pageSize);
        }

        return reservationDao.selectHotelReservationInfo(page, customerId);
    }

    @Override
    public IPage<CarReservationDTO> selectCarReservationInfoByPage(Integer pageNum, Integer pageSize, Integer customerId) {
        Page<CarReservationDTO> page = new Page<>(1, Integer.MAX_VALUE);
        if (pageNum > 0 && pageSize > 0) {
            page = new Page<>(pageNum, pageSize);
        }

        return reservationDao.selectCarReservationInfo(page, customerId);
    }
}

package com.ustc.travelbook.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ustc.travelbook.dao.CustomerDao;
import com.ustc.travelbook.dao.FlightDao;
import com.ustc.travelbook.dao.ReservationDao;
import com.ustc.travelbook.dto.CarReservationDTO;
import com.ustc.travelbook.dto.FlightReservationDTO;
import com.ustc.travelbook.dto.HotelReservationDTO;
import com.ustc.travelbook.dto.ResultMessage;
import com.ustc.travelbook.enums.ReservationEnum;
import com.ustc.travelbook.po.CustomerPO;
import com.ustc.travelbook.po.FlightPO;
import com.ustc.travelbook.po.ReservationPO;
import com.ustc.travelbook.service.IReservationService;
import com.ustc.travelbook.utils.TravelBookUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * @author shanjizhong
 * @date 2019/12/27 16:54
 */
@Slf4j
@Service
public class ReservationServiceImpl implements IReservationService {

    @Autowired
    ReservationDao reservationDao;

    @Autowired
    CustomerDao customerDao;

    @Autowired
    FlightDao flightDao;


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

    @Override
    @Transactional
    public ResultMessage insertFlightReservation(Integer customerId, String flightNum) throws Exception {

        QueryWrapper<CustomerPO> customerQw = new QueryWrapper<CustomerPO>().eq("id", customerId);
        QueryWrapper<FlightPO> flightQw = new QueryWrapper<FlightPO>().eq("flightNum", flightNum);

        CustomerPO customerPo = customerDao.selectById(customerId);
        if (Objects.isNull(customerPo)) {
            return ResultMessage.failed("找不到对应id的用户");
        }
        FlightPO flightPo = flightDao.selectOne(new QueryWrapper<FlightPO>().eq("flight_num", flightNum));
        if (Objects.isNull(flightPo)) {
            return ResultMessage.failed("找不到对应航班号的航班");
        }
        if (flightPo.getAvailableNum() < 1) {
            return ResultMessage.failed("预订航班已无可用座位");
        }

        String key = TravelBookUtils.generateRandomKey();
        String secretKey = TravelBookUtils.encryptWithMd5(key);
        ReservationPO po = ReservationPO.builder()
                                .customerId(customerId)
                                .reservationType(ReservationEnum.FLIGHT.getCode())
                                .targetId(flightPo.getId())
                                .reservationKey(secretKey).build();
        reservationDao.insert(po);
        flightDao.subAvailableSeat(flightPo.getId());

        return ResultMessage.success("请牢记您的预订密钥：" + key);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultMessage cancelFlightReservation(Integer reservationId) {
        ReservationPO reservationPo = reservationDao.selectById(reservationId);

        int count = reservationDao.deleteById(reservationId);
        if (count > 0) {
            flightDao.addAvailableSeat(reservationPo.getId());
            return ResultMessage.success();
        }
        return ResultMessage.failed();
    }
}

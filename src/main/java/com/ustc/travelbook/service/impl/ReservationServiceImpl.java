package com.ustc.travelbook.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ustc.travelbook.dao.*;
import com.ustc.travelbook.dto.*;
import com.ustc.travelbook.enums.ReservationEnum;
import com.ustc.travelbook.po.*;
import com.ustc.travelbook.service.IReservationService;
import com.ustc.travelbook.utils.TravelBookUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
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

    @Autowired
    CarDao carDao;

    @Autowired
    HotelDao hotelDao;


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

        return ResultMessage.success("请牢记您的预订密钥，丢失不补：" + key);
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

    @Override
    public ResultMessage insertCarReservation(Integer customerId, String carType) throws Exception {
        CustomerPO customerPo = customerDao.selectById(customerId);
        if (Objects.isNull(customerPo)) {
            return ResultMessage.failed("找不到对应id的用户");
        }
        CarPO carPo = carDao.selectOne(new QueryWrapper<CarPO>().eq("type", carType));
        if (Objects.isNull(carPo)) {
            return ResultMessage.failed("找不到对应车型的出租车");
        }
        if (carPo.getAvailableNum() < 1) {
            return ResultMessage.failed("预订车型已无闲车");
        }

        String key = TravelBookUtils.generateRandomKey();
        String secretKey = TravelBookUtils.encryptWithMd5(key);
        ReservationPO po = ReservationPO.builder()
                .customerId(customerId)
                .reservationType(ReservationEnum.CAR.getCode())
                .targetId(carPo.getId())
                .reservationKey(secretKey).build();
        reservationDao.insert(po);
        carDao.subAvailableCar(carPo.getId());

        return ResultMessage.success("请牢记您的预订密钥，丢失不补：" + key);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultMessage cancelCarReservation(Integer reservationId) {
        ReservationPO reservationPo = reservationDao.selectById(reservationId);

        int count = reservationDao.deleteById(reservationId);
        if (count > 0) {
            carDao.addAvailableCar(reservationPo.getId());
            return ResultMessage.success();
        }
        return ResultMessage.failed();
    }

    @Override
    public ResultMessage insertHotelReservation(Integer customerId, String hotelName) throws Exception {
        CustomerPO customerPo = customerDao.selectById(customerId);
        if (Objects.isNull(customerPo)) {
            return ResultMessage.failed("找不到对应id的用户");
        }
        HotelPO hotelPo = hotelDao.selectOne(new QueryWrapper<HotelPO>().eq("name", hotelName));
        if (Objects.isNull(hotelPo)) {
            return ResultMessage.failed("找不到宾馆");
        }
        if (hotelPo.getAvailableNum() < 1) {
            return ResultMessage.failed("预订宾馆已无空房");
        }

        String key = TravelBookUtils.generateRandomKey();
        String secretKey = TravelBookUtils.encryptWithMd5(key);
        ReservationPO po = ReservationPO.builder()
                .customerId(customerId)
                .reservationType(ReservationEnum.HOTEL.getCode())
                .targetId(hotelPo.getId())
                .reservationKey(secretKey).build();
        reservationDao.insert(po);
        hotelDao.subAvailableRoom(hotelPo.getId());

        return ResultMessage.success("请牢记您的预订密钥，丢失不补：" + key);
    }

    @Override
    public ResultMessage cancelHotelReservation(Integer reservationId) {
        ReservationPO reservationPo = reservationDao.selectById(reservationId);

        int count = reservationDao.deleteById(reservationId);
        if (count > 0) {
            hotelDao.addAvailableRoom(reservationPo.getId());
            return ResultMessage.success();
        }
        return ResultMessage.failed();
    }

    @Override
    public List<TravelPathDTO> getTravelPathByCustomerId(Integer customerId) {
        List<FlightReservationDTO> records = selectFlightReservationInfoByPage(0, 0, customerId).getRecords();

        List<TravelPathDTO> path = new ArrayList<>();
        records.forEach(dto -> {
            TravelPathDTO pathDto = new TravelPathDTO();
            BeanUtils.copyProperties(dto, pathDto);
            path.add(pathDto);
        });

        return path;
    }
}

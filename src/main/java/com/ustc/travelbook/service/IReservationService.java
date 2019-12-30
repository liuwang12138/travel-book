package com.ustc.travelbook.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ustc.travelbook.dto.*;

import java.util.List;

/**
 * @author shanjizhong
 * @date 2019/12/27 16:17:27
 */
public interface IReservationService {

    IPage<FlightReservationDTO> selectFlightReservationInfoByPage(Integer pageNum, Integer pageSize, Integer customerId);

    IPage<HotelReservationDTO> selectHotelReservationInfoByPage(Integer pageNum, Integer pageSize, Integer customerId);

    IPage<CarReservationDTO> selectCarReservationInfoByPage(Integer pageNum, Integer pageSize, Integer customerId);

    ResultMessage insertFlightReservation(Integer customerId, String flightNum) throws Exception;

    ResultMessage cancelFlightReservation(Integer reservationId);

    ResultMessage insertCarReservation(Integer customerId, String carType) throws Exception;

    ResultMessage cancelCarReservation(Integer reservationId);

    ResultMessage insertHotelReservation(Integer customerId, String hotelName) throws Exception;

    ResultMessage cancelHotelReservation(Integer reservationId);

    List<TravelPathDTO> getTravelPathByCustomerId(Integer customerId);
}

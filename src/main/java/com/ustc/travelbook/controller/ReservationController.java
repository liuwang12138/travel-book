package com.ustc.travelbook.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ustc.travelbook.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author shanjizhong
 * @date 2019/12/27 16:11
 */
@Slf4j
@RestController
@RequestMapping("reservation")
public class ReservationController extends AbstractController {

    @PostMapping("flight/list")
    public IPage<FlightReservationDTO> selectFlightReservationList(@RequestParam(value = "pageNum", required = false, defaultValue = "0") Integer pageNum,
                                                                   @RequestParam(value = "pageSize", required = false, defaultValue =  "0") Integer pageSize,
                                                                   @RequestParam(value = "customerId", required = false) Integer customerId) {
        return reservationService.selectFlightReservationInfoByPage(pageNum, pageSize, customerId);
    }

    @PostMapping("car/list")
    public IPage<CarReservationDTO> selectCarReservationList(@RequestParam(value = "pageNum", required = false, defaultValue = "0") Integer pageNum,
                                                             @RequestParam(value = "pageSize", required = false, defaultValue =  "0") Integer pageSize,
                                                             @RequestParam(value = "customerId", required = false) Integer customerId) {

        return reservationService.selectCarReservationInfoByPage(pageNum, pageSize, customerId);
    }

    @PostMapping("hotel/list")
    public IPage<HotelReservationDTO> selectHotelReservationList(@RequestParam(value = "pageNum", required = false, defaultValue = "0") Integer pageNum,
                                                                 @RequestParam(value = "pageSize", required = false, defaultValue =  "0") Integer pageSize,
                                                                 @RequestParam(value = "customerId", required = false) Integer customerId) {

        return reservationService.selectHotelReservationInfoByPage(pageNum, pageSize, customerId);
    }

    @PostMapping("flight/insert")
    public ResultMessage insertFlightReservation(@RequestParam(value = "customerId") Integer customerId,
                                                 @RequestParam(value = "flightNum") String flightNum) throws Exception {
        return reservationService.insertFlightReservation(customerId, flightNum);
    }

    @PostMapping("flight/cancel")
    public ResultMessage cancelFlightReservation(@RequestParam(value = "reservationId") Integer reservationId) {
        return reservationService.cancelFlightReservation(reservationId);
    }

    @PostMapping("car/insert")
    public ResultMessage insertCarReservation(@RequestParam(value = "customerId") Integer customerId,
                                              @RequestParam(value = "carType") String carType) throws Exception {
        return reservationService.insertCarReservation(customerId, carType);
    }

    @PostMapping("car/cancel")
    public ResultMessage cancelCarReservation(@RequestParam(value = "reservationId") Integer reservationId) {
        return reservationService.cancelCarReservation(reservationId);
    }

    @PostMapping("hotel/insert")
    public ResultMessage insertHotelReservation(@RequestParam(value = "customerId") Integer customerId,
                                                @RequestParam(value = "hotelName") String hotelName) throws Exception {
        return reservationService.insertHotelReservation(customerId, hotelName);
    }

    @PostMapping("hotel/cancel")
    public ResultMessage cancelHotelReservation(@RequestParam(value = "reservationId") Integer reservationId) {
        return reservationService.cancelHotelReservation(reservationId);
    }

    @PostMapping(value = "path")
    public List<TravelPathDTO> getTravelPath(@RequestParam(value = "customerId") Integer customerId) {
        return reservationService.getTravelPathByCustomerId(customerId);
    }

}

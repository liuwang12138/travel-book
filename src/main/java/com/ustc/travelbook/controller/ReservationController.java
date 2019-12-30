package com.ustc.travelbook.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ustc.travelbook.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author shanjizhong
 * @date 2019/12/27 16:11
 */
@Slf4j
@Controller
@RequestMapping("reservation")
public class ReservationController extends AbstractController {

    @GetMapping("flight/list")
    public String selectFlightReservationList(@RequestParam(value = "pageNum", required = false, defaultValue = "0") Integer pageNum,
                                              @RequestParam(value = "pageSize", required = false, defaultValue =  "0") Integer pageSize,
                                              @RequestParam(value = "customerId", required = false) Integer customerId,
                                              Model model) {

        IPage<FlightReservationDTO> flightReservationInfo = reservationService.selectFlightReservationInfoByPage(pageNum, pageSize, customerId);
        model.addAttribute("flightReservationInfo", flightReservationInfo);

        return "reservation/flight_reservation";
    }

    @GetMapping("car/list")
    public String selectCarReservationList(@RequestParam(value = "pageNum", required = false, defaultValue = "0") Integer pageNum,
                                           @RequestParam(value = "pageSize", required = false, defaultValue =  "0") Integer pageSize,
                                           @RequestParam(value = "customerId", required = false) Integer customerId,
                                           Model model) {

        IPage<CarReservationDTO> carReservationInfo = reservationService.selectCarReservationInfoByPage(pageNum, pageSize, customerId);
        model.addAttribute("carReservationInfo", carReservationInfo);

        return "reservation/car_reservation";
    }

    @GetMapping("hotel/list")
    public String selectHotelReservationList(@RequestParam(value = "pageNum", required = false, defaultValue = "0") Integer pageNum,
                                             @RequestParam(value = "pageSize", required = false, defaultValue =  "0") Integer pageSize,
                                             @RequestParam(value = "customerId", required = false) Integer customerId,
                                             Model model) {

        IPage<HotelReservationDTO> hotelReservationInfo = reservationService.selectHotelReservationInfoByPage(pageNum, pageSize, customerId);
        model.addAttribute("hotelReservationInfo", hotelReservationInfo);

        return "reservation/hotel_reservation";
    }

    @ResponseBody
    @PostMapping("flight/insert")
    public ResultMessage insertFlightReservation(@RequestParam(value = "customerId") Integer customerId,
                                                 @RequestParam(value = "flightNum") String flightNum) throws Exception {
        return reservationService.insertFlightReservation(customerId, flightNum);
    }

    @ResponseBody
    @PostMapping("flight/cancel")
    public ResultMessage cancelFlightReservation(@RequestParam(value = "reservationId") Integer reservationId) {
        return reservationService.cancelFlightReservation(reservationId);
    }

    @ResponseBody
    @PostMapping("car/insert")
    public ResultMessage insertCarReservation(@RequestParam(value = "customerId") Integer customerId,
                                              @RequestParam(value = "carType") String carType) throws Exception {
        return reservationService.insertCarReservation(customerId, carType);
    }

    @ResponseBody
    @PostMapping("car/cancel")
    public ResultMessage cancelCarReservation(@RequestParam(value = "reservationId") Integer reservationId) {
        return reservationService.cancelCarReservation(reservationId);
    }

    @ResponseBody
    @PostMapping("hotel/insert")
    public ResultMessage insertHotelReservation(@RequestParam(value = "customerId") Integer customerId,
                                                @RequestParam(value = "hotelName") String hotelName) throws Exception {
        return reservationService.insertHotelReservation(customerId, hotelName);
    }

    @ResponseBody
    @PostMapping("hotel/cancel")
    public ResultMessage cancelHotelReservation(@RequestParam(value = "reservationId") Integer reservationId) {
        return reservationService.cancelHotelReservation(reservationId);
    }

    @GetMapping(value = "path")
    public String getTravelPath(@RequestParam(value = "customerId") Integer customerId,
                                Model model) {
        List<TravelPathDTO> travelPath = reservationService.getTravelPathByCustomerId(customerId);
        model.addAttribute("travelPath", travelPath);

        return "travel_path";
    }

}

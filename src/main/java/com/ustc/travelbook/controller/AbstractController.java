package com.ustc.travelbook.controller;

import com.ustc.travelbook.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author shanjizhong
 * @date 2019/12/26 13:33
 */
public class AbstractController {
    @Autowired
    ICustomerService customerService;

    @Autowired
    IFlightService flightService;

    @Autowired
    ICarService carService;

    @Autowired
    IHotelService hotelService;

    @Autowired
    IReservationService reservationService;


}

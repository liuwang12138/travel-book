package com.ustc.travelbook.controller;

import com.ustc.travelbook.service.ICarService;
import com.ustc.travelbook.service.ICustomerService;
import com.ustc.travelbook.service.IFlightService;
import com.ustc.travelbook.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author liuwang
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


}

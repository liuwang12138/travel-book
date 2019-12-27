package com.ustc.travelbook.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ustc.travelbook.dto.CarReservationDTO;
import com.ustc.travelbook.dto.FlightReservationDTO;
import com.ustc.travelbook.dto.HotelReservationDTO;

/**
 * @author shanjizhong
 * @date 2019/12/27 16:17:27
 */
public interface IReservationService {

    IPage<FlightReservationDTO> selectFlightReservationInfoByPage(Integer pageNum, Integer pageSize, Integer customerId);

    IPage<HotelReservationDTO> selectHotelReservationInfoByPage(Integer pageNum, Integer pageSize, Integer customerId);

    IPage<CarReservationDTO> selectCarReservationInfoByPage(Integer pageNum, Integer pageSize, Integer customerId);

}

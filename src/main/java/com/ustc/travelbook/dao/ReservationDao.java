package com.ustc.travelbook.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ustc.travelbook.dto.CarReservationDTO;
import com.ustc.travelbook.dto.FlightReservationDTO;
import com.ustc.travelbook.dto.HotelReservationDTO;
import com.ustc.travelbook.po.ReservationPO;
import org.apache.ibatis.annotations.Param;

/**
 * @author shanjizhong
 * @date 2019/12/26 11:33
 */
public interface ReservationDao extends BaseMapper<ReservationPO> {

    IPage<FlightReservationDTO> selectFlightReservationInfo(Page<FlightReservationDTO> page, @Param("customerId") Integer customerId);

    IPage<CarReservationDTO> selectCarReservationInfo(Page<CarReservationDTO> page, @Param("customerId") Integer customerId);

    IPage<HotelReservationDTO> selectHotelReservationInfo(Page<HotelReservationDTO> page, @Param("customerId") Integer customerId);

}

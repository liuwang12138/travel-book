package com.ustc.travelbook.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ustc.travelbook.po.FlightPO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author shanjizhong
 * @date 2019/12/26 11:32
 */
public interface FlightDao extends BaseMapper<FlightPO> {

    @Update("update `flight` set `available_num` = `available_num` - 1 where `id` = #{flightId} ")
    int subAvailableSeat(@Param("flightId") Integer flightId);

    @Update("update `flight` set `available_num` = `available_num` + 1 where `id` = #{flightId} ")
    int addAvailableSeat(@Param("flightId") Integer flightId);

}

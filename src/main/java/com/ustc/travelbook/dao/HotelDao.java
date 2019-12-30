package com.ustc.travelbook.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ustc.travelbook.po.HotelPO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author shanjizhong
 * @date 2019/12/26 11:33
 */
public interface HotelDao extends BaseMapper<HotelPO> {

    @Update("update `hotel` set `available_num` = `available_num` - 1 where `id` = #{id} ")
    void subAvailableRoom(@Param("id") Integer id);

    @Update("update `hotel` set `available_num` = `available_num` + 1 where `id` = #{id} ")
    void addAvailableRoom(@Param("id") Integer id);

}

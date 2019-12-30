package com.ustc.travelbook.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ustc.travelbook.po.CarPO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author shanjizhong
 * @date 2019/12/26 11:32:19
 */
public interface CarDao extends BaseMapper<CarPO> {

    @Update("update `car` set `available_num` = `available_num` - 1 where `id` = #{id} ")
    void subAvailableCar(@Param("id") Integer id);

    @Update("update `car` set `available_num` = `available_num` + 1 where `id` = #{id} ")
    void addAvailableCar(@Param("id") Integer id);
}

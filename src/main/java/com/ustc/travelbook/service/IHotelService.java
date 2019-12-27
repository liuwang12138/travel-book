package com.ustc.travelbook.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ustc.travelbook.po.FlightPO;
import com.ustc.travelbook.po.HotelPO;

/**
 * @author shanjizhong
 * @date 2019/12/27 11:49:40
 */
public interface IHotelService {

    void insertHotel(HotelPO po) throws Exception;

    Page<HotelPO> selectByPage(Integer pageNum, Integer pageSize);

    Boolean deleteById(Integer id);

}

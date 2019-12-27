package com.ustc.travelbook.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ustc.travelbook.po.CarPO;
import com.ustc.travelbook.po.FlightPO;

/**
 * @author shanjizhong
 * @date 2019/12/27 11:49:40
 */
public interface ICarService {

    void insertCar(CarPO po) throws Exception;

    Page<CarPO> selectByPage(Integer pageNum, Integer pageSize);

    Boolean deleteById(Integer id);

}

package com.ustc.travelbook.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ustc.travelbook.po.CustomerPO;

/**
 * @author shanjizhong
 * @date 2019/12/26 11:44
 */
public interface ICustomerService {

    void insertCustomer(String customerName);

    Page<CustomerPO> selectByPage(Integer pageNum, Integer pageSize);

    Boolean deleteById(Integer id);

}

package com.ustc.travelbook.service.impl;

import com.ustc.travelbook.dao.CustomerDao;
import com.ustc.travelbook.po.CustomerPO;
import com.ustc.travelbook.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuwang
 * @date 2019/12/26 11:45
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    CustomerDao customerDao;

    @Override
    public void insertCustomer(String customerName) {

        CustomerPO customerPo = CustomerPO.builder()
                                      .customerName(customerName).build();
        customerDao.insert(customerPo);
    }
}

package com.ustc.travelbook.service.impl;

import com.ustc.travelbook.dao.CustomerDao;
import com.ustc.travelbook.po.CustomerPO;
import com.ustc.travelbook.service.ICustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuwang
 * @date 2019/12/26 11:45
 */
@Slf4j
@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    CustomerDao customerDao;

    @Override
    public void insertCustomer(String customerName) {

        log.info("insert costumer...");
        CustomerPO customerPo = CustomerPO.builder()
                                      .customerName(customerName).build();
        customerDao.insert(customerPo);
    }
}

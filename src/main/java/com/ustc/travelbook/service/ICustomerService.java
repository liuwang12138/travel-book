package com.ustc.travelbook.service;

import com.ustc.travelbook.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author shanjizhong
 * @date 2019/12/26 11:44
 */
public interface ICustomerService {

    void insertCustomer(String customerName);

}

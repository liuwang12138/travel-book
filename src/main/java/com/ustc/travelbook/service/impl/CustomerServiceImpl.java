package com.ustc.travelbook.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ustc.travelbook.dao.CustomerDao;
import com.ustc.travelbook.po.CustomerPO;
import com.ustc.travelbook.service.ICustomerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
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

    @Override
    public Page<CustomerPO> selectByPage(Integer pageNum, Integer pageSize) {
        Page<CustomerPO> page = new Page<>(1, Integer.MAX_VALUE);
        if (pageNum > 0 && pageSize > 0) {
            page = new Page<>(pageNum, pageSize);
        }

        return customerDao.selectPage(page, null);
    }

    @Override
    public Boolean deleteById(Integer id) {
        return customerDao.deleteById(id) > 0;
    }
}

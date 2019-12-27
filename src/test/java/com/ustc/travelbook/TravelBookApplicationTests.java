package com.ustc.travelbook;

import com.ustc.travelbook.dao.CustomerDao;
import com.ustc.travelbook.po.CustomerPO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TravelBookApplicationTests {

    @Autowired
    CustomerDao customerDao;

    @Test
    void contextLoads() {
        CustomerPO po = CustomerPO.builder().customerName("111").build();
        customerDao.insert(po);
    }

}

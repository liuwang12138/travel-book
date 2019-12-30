package com.ustc.travelbook;

import com.ustc.travelbook.dao.CustomerDao;
import com.ustc.travelbook.dao.ReservationDao;
import com.ustc.travelbook.enums.ReservationEnum;
import com.ustc.travelbook.po.CustomerPO;
import com.ustc.travelbook.po.ReservationPO;
import com.ustc.travelbook.service.IReservationService;
import com.ustc.travelbook.utils.TravelBookUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TravelBookApplicationTests {

    @Autowired
    CustomerDao customerDao;

    @Autowired
    ReservationDao reservationDao;

    @Test
    void contextLoads() {
        CustomerPO po = CustomerPO.builder().customerName("111").build();
        customerDao.insert(po);
    }

    @Test
    void insertReservationFlight() throws Exception {
        for (int i=0; i<30; i++) {
            ReservationPO reservationPO = new ReservationPO();
            reservationPO.setCustomerId(11);
            reservationPO.setReservationType(ReservationEnum.FLIGHT.getCode());
            reservationPO.setTargetId(10);
            String key = TravelBookUtils.generateRandomKey();
            System.out.println("key" + (i+1) + " = " + key);
            reservationPO.setReservationKey(TravelBookUtils.encryptWithMd5(key));
            reservationDao.insert(reservationPO);
        }
    }

}

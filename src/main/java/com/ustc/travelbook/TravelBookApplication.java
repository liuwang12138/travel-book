package com.ustc.travelbook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shanjizhong
 * @date 2019/12/26 10:53:28
 */
@SpringBootApplication
@MapperScan("com.ustc.travelbook.dao")
public class TravelBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelBookApplication.class, args);
    }

}

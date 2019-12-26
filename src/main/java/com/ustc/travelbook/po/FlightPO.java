package com.ustc.travelbook.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author shanjizhong
 * @date 2019/12/26 11:07
 */

@Data
@TableName("flight")
public class FlightPO {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "flight_num")
    private String flightNum;

    @TableField(value = "price")
    private BigDecimal price;

    @TableField(value = "seat_num")
    private Integer seatNum;

    @TableField(value = "available_num")
    private Integer availableNum;

    @TableField(value = "from_city")
    private String fromCity;

    @TableField(value = "arrive_city")
    private String arriveCity;

    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @TableField(value = "update_time")
    private LocalDateTime updateTime;
}

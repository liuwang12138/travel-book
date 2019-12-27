package com.ustc.travelbook.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author shanjizhong
 * @date 2019/12/26 11:07
 */

@Data
@TableName("flight")
@Builder
public class FlightPO {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @NotNull
    @TableField(value = "flight_num")
    private String flightNum;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    @TableField(value = "price")
    private BigDecimal price;

    @NotNull
    @TableField(value = "seat_num")
    private Integer seatNum;

    @NotNull
    @TableField(value = "available_num")
    private Integer availableNum;

    @NotNull
    @TableField(value = "from_city")
    private String fromCity;

    @NotNull
    @TableField(value = "arrive_city")
    private String arriveCity;

    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    public FlightPO() {
    }

    public FlightPO(Integer id, @NotNull String flightNum, @NotNull @Digits(integer = 10, fraction = 2) BigDecimal price, @NotNull Integer seatNum, @NotNull Integer availableNum, @NotNull String fromCity, @NotNull String arriveCity, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.flightNum = flightNum;
        this.price = price;
        this.seatNum = seatNum;
        this.availableNum = availableNum;
        this.fromCity = fromCity;
        this.arriveCity = arriveCity;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}

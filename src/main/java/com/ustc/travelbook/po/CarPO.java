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
 * @date 2019/12/26 10:56
 */
@Data
@TableName(value = "car")
public class CarPO {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "type")
    private String type;

    @TableField(value = "location")
    private String location;

    @TableField(value = "price")
    private BigDecimal price;

    @TableField(value = "car_num")
    private Integer carNum;

    @TableField(value = "available_num")
    private Integer availableNum;

    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @TableField(value = "update_time")
    private LocalDateTime updateTime;

}

package com.ustc.travelbook.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author shanjizhong
 * @date 2019/12/26 11:10
 */
@Data
@TableName("hotel")
public class HotelPO {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @NotBlank
    @TableField(value = "name")
    private String name;

    @NotBlank
    @TableField(value = "location")
    private String location;

    @NotNull
    @TableField(value = "price")
    private BigDecimal price;

    @NotNull
    @TableField(value = "room_num")
    private Integer roomNum;

    @NotNull
    @TableField(value = "available_num")
    private Integer availableNum;

    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @TableField(value = "update_time")
    private LocalDateTime updateTime;

}

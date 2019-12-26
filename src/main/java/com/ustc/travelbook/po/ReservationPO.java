package com.ustc.travelbook.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author shanjizhong
 * @date 2019/12/26 11:12
 */
@Data
@TableName(value = "reservation")
public class ReservationPO {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "customer_id")
    private Integer customerId;

    @TableField(value = "reservation_type")
    private Integer reservationType;

    @TableField(value = "reservation_key")
    private String reservationKey;

    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @TableField(value = "update_time")
    private LocalDateTime updateTime;

}

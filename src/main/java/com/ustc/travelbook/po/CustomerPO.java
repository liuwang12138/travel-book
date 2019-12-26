package com.ustc.travelbook.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author shanjizhong
 * @date 2019/12/26 11:02
 */

@Data
@Builder
@TableName("customer")
public class CustomerPO {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "customer_name")
    private String customerName;

    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @TableField(value = "update_time")
    private LocalDateTime updateTime;

}

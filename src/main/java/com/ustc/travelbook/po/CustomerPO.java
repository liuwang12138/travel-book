package com.ustc.travelbook.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.format.annotation.DateTimeFormat;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd---HH:mm:ss")
    private LocalDateTime createTime;

    @TableField(value = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd---HH:mm:ss")
    private LocalDateTime updateTime;

}

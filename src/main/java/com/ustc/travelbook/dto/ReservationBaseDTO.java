package com.ustc.travelbook.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author shanjizhong
 * @date 2019/12/27 16:29
 */
@Data
public class ReservationBaseDTO {

    private Integer reservationId;

    private String customerName;

    private BigDecimal price;

    private Integer totalNum;

    private Integer availableNum;

    private String reservationKey;

}

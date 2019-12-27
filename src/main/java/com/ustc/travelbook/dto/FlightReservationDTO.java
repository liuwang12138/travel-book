package com.ustc.travelbook.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author shanjizhong
 * @date 2019/12/27 16:31
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class FlightReservationDTO extends ReservationBaseDTO {

    private String flightNum;

    private String fromCity;

    private String arriveCity;

}

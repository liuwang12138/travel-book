package com.ustc.travelbook.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author shanjizhong
 * @date 2019/12/27 16:33
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class CarReservationDTO extends ReservationBaseDTO {

    private String carType;

    private String location;

}

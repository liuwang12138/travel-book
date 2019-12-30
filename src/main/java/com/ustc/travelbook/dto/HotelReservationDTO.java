package com.ustc.travelbook.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author shanjizhong
 * @date 2019/12/27 16:34
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class HotelReservationDTO extends ReservationBaseDTO {

    private String name;

    private String location;

}

package com.ustc.travelbook.enums;

import lombok.Getter;

import java.util.Arrays;

/**
 * @author shanjizhong
 * @date 2019/12/26 11:15:20
 */
@Getter
public enum ReservationEnum {

    // 航班
    FLIGHT(1, "航班"),
    // 宾馆
    HOTEL(2, "宾馆"),
    // 出租车
    CAR(3, "出租车");

    private Integer code;
    private String value;

    ReservationEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public static String getValueByCode(Integer code) {
        for (ReservationEnum value : ReservationEnum.values()) {
            if (value.code.equals(code)) {
                return value.value;
            }
        }
        return "";
    }
}

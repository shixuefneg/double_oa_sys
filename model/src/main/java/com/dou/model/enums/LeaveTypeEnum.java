package com.dou.model.enums;

/**
 * @author SunHaiLong
 * 请假类型
 * @date 2022/3/3 16:34
 */
public enum  LeaveTypeEnum {

    SICK_LEAVE(0,"病假"),
    COMPASSIONATE_LEAVE(1,"事假"),
    MARRIAGE_LEAVE(2,"婚假"),
    MATERNITY_LEAVE(3,"产假"),
    OTHER_LEAVE(4,"其他");

    private Integer code;
    private String type;

    LeaveTypeEnum(Integer code,String type){
        this.code=code;
        this.type=type;
    }
}

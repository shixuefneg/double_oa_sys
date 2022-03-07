package com.dou.model.enums;



/**
 * @author SunHaiLong
 * @date 2022/3/3 16:47
 * 考勤标准时间
 */
public enum AttendanceTimeEnum {

    //早勤时间
    MORNING_TIME("09:30:00"),
    //晚勤时间
    EVENING_TIME("17:00:00");

    private String attendanceTime;

    AttendanceTimeEnum(String attendanceTime){
        this.attendanceTime=attendanceTime;
    }
}

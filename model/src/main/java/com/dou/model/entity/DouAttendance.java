package com.dou.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author testjava
 * @since 2022-03-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DouAttendance对象", description="")
public class DouAttendance implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "考勤id")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "员工id")
    private String empId;

    @ApiModelProperty(value = "员工早勤实际时间")
    private Date empMorntime;

    @ApiModelProperty(value = "员工晚勤实际时间")
    private Date empEventime;

    @ApiModelProperty(value = "早勤状态 0(准时打卡) 1(迟到) 2(矿工)")
    private Integer empCheckmornstatus;

    @ApiModelProperty(value = "晚勤状态 0(准时打卡) 1(早退) 2(加班) ")
    private Integer empCheckevenstatus;

    @ApiModelProperty(value = "加班时长")
    private Integer workovertime;

    @ApiModelProperty(value = "是否请假 0(未请假) 1(请假)")
    private Integer isLeave;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableLogic
    private Integer isDeleted;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}

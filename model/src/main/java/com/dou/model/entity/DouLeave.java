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
@ApiModel(value="DouLeave对象", description="")
public class DouLeave implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "请假id")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "员工id")
    private String empId;

    @ApiModelProperty(value = "请假类型")
    private String leavetype;

    @ApiModelProperty(value = "请假事由")
    private String leavedescription;

    @ApiModelProperty(value = "请假起始时间")
    private Date leavebegintime;

    @ApiModelProperty(value = "请假结束时间")
    private Date leaveendtime;

    @ApiModelProperty(value = "请假时长")
    private String leaveduration;

    @ApiModelProperty(value = "请假状态 0(请假未结束) 1(请假已结束)")
    private Integer leavestatus;

    @ApiModelProperty(value = "审批状态 0(未审批) 1(审批通过) 2(审批未通过)")
    private Integer attenstatus;

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

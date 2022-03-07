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
@ApiModel(value="DouEmployee对象", description="")
public class DouEmployee implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "员工id")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "员工姓名")
    private String empName;

    @ApiModelProperty(value = "员工年龄")
    private Integer empAge;

    @ApiModelProperty(value = "员工生日")
    private Date empBirthday;

    @ApiModelProperty(value = "员工电话")
    private String empPhone;

    @ApiModelProperty(value = "员工邮箱")
    private String empEmail;

    @ApiModelProperty(value = "员工身份证号")
    private String empIdCard;

    @ApiModelProperty(value = "员工薪资")
    private Double empSalary;

    @ApiModelProperty(value = "员工职位")
    private String empPosition;

    @ApiModelProperty(value = "部门id")
    private String depId;

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

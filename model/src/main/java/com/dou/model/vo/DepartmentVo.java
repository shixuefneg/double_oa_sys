package com.dou.model.vo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Description 部门封装vo类
 * @Author 刘禹
 * @Date 2022/3/4 下午7:19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DouDepartmentVo对象", description="")
public class DepartmentVo implements Serializable {

    @ApiModelProperty(value = "部门id")
    private String id;

    @ApiModelProperty(value = "部门名称")
    private String depName;
    @ApiModelProperty(value = "排序")
    private Integer sort;
    @TableLogic
//    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    private Boolean isDeleted;
    @ApiModelProperty(value = "父级id")
    private String pid;

    @ApiModelProperty(value = "子级部门")
    private List<DepartmentVo> children;
    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;
}

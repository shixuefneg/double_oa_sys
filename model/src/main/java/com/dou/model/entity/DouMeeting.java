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
@ApiModel(value="DouMeeting对象", description="")
public class DouMeeting implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "会议记录id")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "会议标题")
    private String meetTitle;

    @ApiModelProperty(value = "参会人数")
    private Integer meetPeople;

    @ApiModelProperty(value = "会议的开始时间")
    private Date meetStarttime;

    @ApiModelProperty(value = "会议的结束时间")
    private Date meetEndtime;

    @ApiModelProperty(value = "会议室房间号")
    private Integer meetRoom;

    @ApiModelProperty(value = "会议的申请人")
    private String meetApplicant;

    @ApiModelProperty(value = "会议的审批人")
    private String meetApprover;

    @ApiModelProperty(value = "会议进行状态 0(未进行) 1(正在进行) 2(已进行)")
    private Integer isExpire;

    @ApiModelProperty(value = "会议的审批状态 0(未审批) 1(审批通过) 2(审批未通过)")
    private Integer isApprove;

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

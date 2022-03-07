package com.dou.servicedept.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 史学峰
 * @date 2022/3/5 10:29
 */
@Data
public class DepartmentQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "部门名称,模糊查询")
    private String name;

    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private String begin;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换

    @ApiModelProperty(value = "查询结束时间", example = "2019-12-01 10:10:10")
    private String end;
}

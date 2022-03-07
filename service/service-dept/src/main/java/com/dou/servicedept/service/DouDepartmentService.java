package com.dou.servicedept.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dou.model.entity.DouDepartment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dou.model.vo.DepartmentVo;
import com.dou.servicedept.query.DepartmentQuery;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2022-03-03
 */
public interface DouDepartmentService extends IService<DouDepartment> {
    //全查
    List<DepartmentVo> getDeptListAndChildren();
    //分页+模糊
    void pageQuery(Page<DouDepartment> pageParam, DepartmentQuery departmentQuery);
}

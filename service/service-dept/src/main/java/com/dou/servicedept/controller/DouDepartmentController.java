package com.dou.servicedept.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dou.commonutils.util.R;
import com.dou.model.entity.DouDepartment;
import com.dou.model.vo.DepartmentVo;
import com.dou.servicedept.query.DepartmentQuery;
import com.dou.servicedept.service.DouDepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-03-03
 */
@RestController
@RequestMapping("/dept/department")
@Api(description = "部门控制层")
public class DouDepartmentController {

    @Autowired
    private DouDepartmentService departmentService;

    /**
     * 获取部门列表
     */

    @ApiOperation(value = "获取部门层级关系列表")
    @GetMapping("/getDeptList")
    public R getDeptList(){

        List<DepartmentVo> list = departmentService.getDeptListAndChildren();
        return R.ok().data("list",list);
    }

    //逻辑删除
    @ApiOperation(value = "删除部门")
    @DeleteMapping("{id}")
    public R removeDepartment(@ApiParam(name = "id", value = "部门ID", required = true)
                           @PathVariable String id) {
        boolean flag = departmentService.removeById(id);
        if(flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }
    //修改
    @ApiOperation(value = "修改部门")
    @PostMapping("/updateById")
    public R updateTeacher(@RequestBody DouDepartment douDepartment) {
        boolean flag = departmentService.updateById(douDepartment);
        if(flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }
    //添加
    @ApiOperation(value = "新增部门")
    @PostMapping("/addDepartment")
    public R save(
            @ApiParam(name = "teacher", value = "部门对象", required = true)
            @RequestBody DouDepartment douDepartment){

        departmentService.save(douDepartment);
        return R.ok();
    }
    //根据ID查询
    @GetMapping("/getById/{id}")
    public R getById(
            @ApiParam(name = "id", value = "部门ID", required = true) @PathVariable String id
    ){
        DouDepartment byId = departmentService.getById(id);
        return R.ok().data("byId",byId);
    }

    //分页
    @PostMapping("/{page}/{limit}")
    public R pageList(
            @ApiParam(name = "page", value = "当前页码", required = true) @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true) @PathVariable Long limit,
            @RequestBody @ApiParam(name = "DepartmentQuery", value = "查询对象", required = false) DepartmentQuery departmentQuery
    ){
        Page<DouDepartment> pageParam = new Page<>(page, limit);
        departmentService.pageQuery(pageParam,departmentQuery);
        List<DouDepartment> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return  R.ok().data("total", total).data("rows", records);
    }

}


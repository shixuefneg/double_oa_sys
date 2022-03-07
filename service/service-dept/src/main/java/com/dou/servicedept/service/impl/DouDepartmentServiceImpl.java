package com.dou.servicedept.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dou.model.entity.DouDepartment;
import com.dou.model.vo.DepartmentVo;
import com.dou.servicedept.mapper.DouDepartmentMapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dou.servicedept.query.DepartmentQuery;
import com.dou.servicedept.service.DouDepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-03-03
 */
@Service
public class DouDepartmentServiceImpl extends ServiceImpl<DouDepartmentMapper, DouDepartment> implements DouDepartmentService {

    @Override
    public List<DepartmentVo> getDeptListAndChildren() {
        QueryWrapper<DouDepartment> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("id");
        List<DouDepartment> departmentList = baseMapper.selectList(wrapper);
        //封装数据
        ArrayList<DepartmentVo> list = new ArrayList<>();
        for (DouDepartment douDepartment : departmentList) {
            DepartmentVo vo = new DepartmentVo();
            BeanUtils.copyProperties(douDepartment,vo);
            list.add(vo);
        }
        ArrayList<DepartmentVo> resList = new ArrayList<>();
        for (DepartmentVo douDepartment : list) {
            if ("0".equals(douDepartment.getPid())){
                resList.add(getChildren(douDepartment,list));
            }
        }
        return resList;
    }




    public DepartmentVo getChildren(DepartmentVo departmentVo,List<DepartmentVo> list){
        departmentVo.setChildren(new ArrayList<>());
        for (DepartmentVo vo : list) {
            if (vo.getPid().equals(departmentVo.getId())){
                departmentVo.getChildren().add(getChildren(vo,list));
            }
        }
        return departmentVo;
    }

    /**
     * 分页+模糊
     * @param pageParam
     * @param departmentQuery
     */
    @Override
    public void pageQuery(Page<DouDepartment> pageParam, DepartmentQuery departmentQuery) {
        QueryWrapper<DouDepartment> queryWrapper = new QueryWrapper<>();
        if(departmentQuery==null){
            baseMapper.selectPage(pageParam,queryWrapper);
            return;
        }
        String name = departmentQuery.getName();
        String begin = departmentQuery.getBegin();
        String end = departmentQuery.getEnd();
        if (!StringUtils.isEmpty(name)){
            queryWrapper.like("dep_name",name);
        }
        if (!StringUtils.isEmpty(begin)){
            queryWrapper.ge("gmt_create",begin);  //ge大于
        }
        if (!StringUtils.isEmpty(end)){
            queryWrapper.le("gmt_create",end);   //le 小于
        }
        baseMapper.selectPage(pageParam,queryWrapper);
    }

}

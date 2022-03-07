package com.dou.serviceemployee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dou.model.entity.DouEmployee;
import com.dou.serviceemployee.mapper.DouEmployeeMapper;
import com.dou.serviceemployee.service.DouEmployeeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-03-03
 */
@Service
public class DouEmployeeServiceImpl extends ServiceImpl<DouEmployeeMapper, DouEmployee> implements DouEmployeeService {

}

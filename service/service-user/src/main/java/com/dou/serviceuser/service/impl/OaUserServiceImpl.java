package com.dou.serviceuser.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dou.model.entity.OaUser;

import com.dou.serviceuser.mapper.OaUserMapper;
import com.dou.serviceuser.service.OaUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-03-03
 */
@Service
public class OaUserServiceImpl extends ServiceImpl<OaUserMapper, OaUser> implements OaUserService {

}

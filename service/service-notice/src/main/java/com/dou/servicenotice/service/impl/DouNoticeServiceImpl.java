package com.dou.servicenotice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dou.model.entity.DouNotice;

import com.dou.servicenotice.mapper.DouNoticeMapper;
import com.dou.servicenotice.service.DouNoticeService;
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
public class DouNoticeServiceImpl extends ServiceImpl<DouNoticeMapper, DouNotice> implements DouNoticeService {

}

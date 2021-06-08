package com.sznt.shop.user.service.impl;

import com.sznt.shop.user.model.UserDO;
import com.sznt.shop.user.mapper.UserMapper;
import com.sznt.shop.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户表 服务实现类
 *
 * @author S Mr.L
 * @since 2021-06-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    @Autowired
    private UserMapper userMapper;

}

package com.briup.apps.cms.service.impl;

import com.briup.apps.cms.bean.User;
import com.briup.apps.cms.bean.UserExample;
import com.briup.apps.cms.bean.UserRole;
import com.briup.apps.cms.bean.extend.UserExtend;
import com.briup.apps.cms.dao.UserMapper;
import com.briup.apps.cms.dao.UserRoleMapper;
import com.briup.apps.cms.dao.extend.UserExtendMapper;
import com.briup.apps.cms.dao.extend.UserRoleExtendMapper;
import com.briup.apps.cms.service.IUserService;
import com.briup.apps.cms.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (C) @2019 zunhui Qiang_zunhui@tom.com
 *
 * @author zunhui
 * @version 1.0
 * @ClassName UserServiceImpl
 * @date 2019-11-14 20:02
 * @description 用户管理信息相关类
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserExtendMapper userExtendMapper;

    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private UserRoleExtendMapper userRoleExtendMapper;

    @Override
    public List<User> findAll() {
        return userMapper.selectByExample(new UserExample());
    }

    //查询用户
    @Override
    public User findById(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public UserExtend extendFindById(long id) {
        return userExtendMapper.selectById(id);
    }

    @Override
    public List<UserExtend> findExtendAll() {
        return userExtendMapper.findExtendAll();
    }

    //删除用户
    @Override
    public void deleteByid(long id) throws CustomerException {
        User user = findById(id);
        if(user==null){
            throw new CustomerException("该用户不存在");
        }else {
            userMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void batchDeleteByIds(long[] ids) throws CustomerException {
            if (ids!=null&&ids.length>0){
                for (long id:ids) {
                    deleteByid(id);
                }
            }
    }
    //更新用户信息
    @Override
    public void updateUser(User user) throws CustomerException {
        userMapper.updateByPrimaryKey(user);
    }
    //用户注册
    @Override
    public void addUser(User user) throws CustomerException {

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(user.getUsername());
        List<User> list = userMapper.selectByExample(userExample);
        if (list.size()>0){
            throw  new CustomerException("用户名已存在");
        }
        userMapper.insert(user);
    }

    @Override
    public void setRoles(Long id, List<Long> roles) throws CustomerException {
        //根据user_id查parent_id
        List<Long> oldRoles = userExtendMapper.selectByUserId(id);
        
        //对比roles和查询结果，进行设置权限
        // [1,2,3] -> [3,4] 添加1,2 => [1,2,3,4]
        // 依次判断新角色是否存在于list中，如果不存在则添加
        UserRole userRole = new UserRole();
        for(Long roleId : roles){
            if(!oldRoles.contains(roleId)){
                userRole.setUserId(id);
                userRole.setRoleId(roleId);
                //插入
                userRoleMapper.insert(userRole);
            }
        }
        // [1,2,3] -> [1,2,3,4]   删除 3,4  => [1,2]
        // 依次判断老的角色是否存在于roles中，如果不存在则删除
        for(Long oldId : oldRoles){
            if (!roles.contains(oldId)){
                userRoleExtendMapper.deleteByRoleId(oldId);
            }
        }
    }
}

package com.briup.apps.cms.service;

import com.briup.apps.cms.bean.User;
import com.briup.apps.cms.bean.extend.UserExtend;
import com.briup.apps.cms.utils.CustomerException;
import com.briup.apps.cms.vm.UserVm;

import java.util.List;

/**
 * Copyright (C) @2019 zunhui Qiang_zunhui@tom.com
 *
 * @author zunhui
 * @version 1.0
 * @ClassName IUserService
 * @date 2019-11-14 19:55
 * @description 用户管理相关接口
 */
public interface IUserService {
    //查询所有用户
    List<User> findAll();

    //根据id查询用户信息
    User findById(long id);
    //查询用户角色信息
    UserExtend extendFindById(long id);

    //查询用户及其角色
    List<UserExtend> findExtendAll();

    //删除用户
    void deleteByid(long id) throws CustomerException;

    //批量删除用户
    void batchDeleteByIds(long[] ids)throws CustomerException;

    //修改用户信息
    void updateUser(User user) throws CustomerException;

    //注册
    void addUser(User user) throws CustomerException;

    //修改用户角色
    void setRoles(Long id, List<Long> roles) throws CustomerException;

    User login(UserVm userVm);
}

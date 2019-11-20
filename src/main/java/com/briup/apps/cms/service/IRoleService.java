package com.briup.apps.cms.service;

import com.briup.apps.cms.bean.Role;
import com.briup.apps.cms.bean.extend.RoleExtend;
import com.briup.apps.cms.utils.CustomerException;
import com.briup.apps.cms.vm.RolePrivilegeVm;

import java.util.List;

/**
 * Copyright (C) @2019 zunhui Qiang_zunhui@tom.com
 *
 * @author zunhui
 * @version 1.0
 * @ClassName IRoleService
 * @date 2019-11-18 09:34
 * @description TODO
 */
public interface IRoleService {

    //添加角色
    void addRole(String name)throws CustomerException;
    //删除角色
    void deleteById(long id)throws CustomerException;

    List<Role> findAll();

    //查询所有角色及权限
    List<RoleExtend> cascadePrivilegeFindAll();

    //设置角色权限
    void setRolePrivilege(RolePrivilegeVm role)throws CustomerException;

}

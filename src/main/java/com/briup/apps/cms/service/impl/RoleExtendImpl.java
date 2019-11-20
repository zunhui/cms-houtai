package com.briup.apps.cms.service.impl;

import com.briup.apps.cms.bean.Privilege;
import com.briup.apps.cms.bean.Role;
import com.briup.apps.cms.bean.RoleExample;
import com.briup.apps.cms.bean.RolePrivilege;
import com.briup.apps.cms.bean.extend.RoleExtend;
import com.briup.apps.cms.dao.RoleMapper;
import com.briup.apps.cms.dao.RolePrivilegeMapper;
import com.briup.apps.cms.dao.extend.PrivilegeExtendMapper;
import com.briup.apps.cms.dao.extend.RoleExtendMapper;
import com.briup.apps.cms.dao.extend.RolePrivilegeExtendMapper;
import com.briup.apps.cms.service.IRoleService;
import com.briup.apps.cms.utils.CustomerException;
import com.briup.apps.cms.vm.RolePrivilegeVm;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) @2019 zunhui Qiang_zunhui@tom.com
 *
 * @author zunhui
 * @version 1.0
 * @ClassName RoleExtend
 * @date 2019-11-18 09:47
 * @description 类
 */
@Service
public class RoleExtendImpl implements IRoleService {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private RoleExtendMapper roleExtendMapper;

    @Resource
    private PrivilegeExtendMapper privilegeExtendMapper;

    @Resource
    private RolePrivilegeMapper rolePrivilegeMapper;

    @Resource
    private RolePrivilegeExtendMapper rolePrivilegeExtendMapper;

    @Override
    public void addRole(String name) throws CustomerException {
        Role role = roleExtendMapper.selectByName(name);
        if (role!=null){
            throw new CustomerException("该角色已经存在!");
        }
        Role newrole = new Role();
        newrole.setName(name);
        roleMapper.insert(newrole);
    }

    @Override
    public void deleteById(long id) throws CustomerException {
        roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Role> findAll() {
        return roleMapper.selectByExample(new RoleExample());
    }

    @Override
    public List<RoleExtend> cascadePrivilegeFindAll() {
        return roleExtendMapper.cascadePrivilegeFindAll();
    }

    @Override
    public void setRolePrivilege(RolePrivilegeVm role) throws CustomerException {

        List<Privilege> oldPrivileges = privilegeExtendMapper.selectByRoleId(role.getId());
        //获取旧q权限id数组
        List<Long> oldPIds = new ArrayList<>();
        for (Privilege p : oldPrivileges) {
            oldPIds.add(p.getId());
        }
        //获取新权限id数组
        List<Long> newPIds = role.getPrivileges();
        //遍历判断新的是否存在于旧的
        for (Long newPId:newPIds) {
            if (!oldPIds.contains(newPId)){
                RolePrivilege privilege = new RolePrivilege();
                privilege.setRoleId(role.getId());
                privilege.setPrivilegeId(newPId);
                rolePrivilegeMapper.insert(privilege);
            }
        }
        //遍历判断旧权限是否存在于新权限中
        for (Long oldPid:oldPIds){
         if (!newPIds.contains(oldPid)) {
             rolePrivilegeExtendMapper.deleteByPrivilegeId(oldPid);
         }
        }
    }
}

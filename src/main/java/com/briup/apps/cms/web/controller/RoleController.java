package com.briup.apps.cms.web.controller;

import com.briup.apps.cms.bean.Role;
import com.briup.apps.cms.bean.extend.RoleExtend;
import com.briup.apps.cms.service.IRoleService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;
import com.briup.apps.cms.vm.RolePrivilegeVm;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Copyright (C) @2019 zunhui Qiang_zunhui@tom.com
 *
 * @author zunhui
 * @version 1.0
 * @ClassName RoleController
 * @date 2019-11-18 10:02
 * @description 角色操作相关类
 */
@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private IRoleService service;


    @ApiOperation("根据id删除角色")
    @GetMapping("deleteById")
    public Message deleteById(long id){
        service.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation("查询所有角色")
    @GetMapping("findAll")
    public Message findAll(){
        List<Role> list = service.findAll();
        return MessageUtil.success(list);
    }

    @ApiOperation("查询所有角色及其权限")
    @GetMapping("cascadePrivilegeFindAll")
    public Message cascadePrivilegeFindAll(){
        List<RoleExtend> list = service.cascadePrivilegeFindAll();
        return MessageUtil.success(list);
    }

    @ApiOperation("设置角色权限")
    @PostMapping("setRolePrivilege")
    public Message setRolePrivilege(RolePrivilegeVm role){
        service.setRolePrivilege(role);
        return MessageUtil.success("更新成功!");
    }
}

package com.briup.apps.cms.web.controller;

/**
 * Copyright (C) @2019 qiangzunhui@126.com
 *
 * @author zunhui
 * @version 1.0
 * @ClassName PrivilegeControler
 * @date 2019-11-19 09:25
 * @description 权限控制器
 */

import com.briup.apps.cms.bean.Privilege;
import com.briup.apps.cms.service.IPrivilegeService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;
import com.briup.apps.cms.vm.PrivilegeTree;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("privilege")
public class PrivilegeControler {

    @Autowired
    private IPrivilegeService service;

    //查询权限
    @ApiOperation("查询权限及其子权限")
    @GetMapping("findByParentId")
    public Message findByParentId(Long id){
        List<Privilege> list = service.findByParentId(id);
        return MessageUtil.success(list);
    }

    //修改或保存权限
    @ApiOperation("修改或保存权限")
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Privilege privilege){
        service.saveOrUpdate(privilege);
        return MessageUtil.success("更新成功!");
    }

    @ApiOperation("查询权限树")
    @GetMapping("findPrivilegeTree")
    public Message findPrivilegeTree(){
        List<PrivilegeTree> list = service.findPrivilegeTree();
        return MessageUtil.success(list);
    }

}

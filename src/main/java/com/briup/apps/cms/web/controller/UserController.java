package com.briup.apps.cms.web.controller;

import com.briup.apps.cms.bean.User;
import com.briup.apps.cms.bean.extend.UserExtend;
import com.briup.apps.cms.service.IUserService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;
import com.briup.apps.cms.vm.UserRoleVm;
import com.briup.apps.cms.vm.UserVm;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.stream.FileImageInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C) @2019 zunhui Qiang_zunhui@tom.com
 *
 * @author zunhui
 * @version 1.0
 * @ClassName UserController
 * @date 2019-11-14 20:18
 * @description 用户相关类
 */
@RestController
//@Api(tags = "用户相关接口")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userservice;

    @ApiOperation("设置用户角色")
    @PostMapping("setRoles")
    public Message setRoles(UserRoleVm userRoleVm){
        userservice.setRoles(userRoleVm.getId(),userRoleVm.getRoles());
        return MessageUtil.success("修改成功!");
    }


    @ApiOperation("查询所有用户")
    @GetMapping("findAll")
    public Message findAll(){
        return MessageUtil.success(userservice.findAll());
    }

    @ApiOperation("查询所有用户及其角色信息")
    @GetMapping("findExtendAll")
    public Message findExtendAll(){
        return MessageUtil.success(userservice.findExtendAll());
    }

    @ApiOperation("注册用户")
    @PostMapping("addUser")
    public Message addUser(User user){
        user.setStatus("正常");
        user.setUserFace("普通用户");
        userservice.addUser(user);
        return MessageUtil.success("添加成功!");
    }

    @ApiOperation("批量删除用户")
    @PostMapping("batchDeleteById")
    public Message batchDeleteById(@RequestBody long[] ids){
        userservice.batchDeleteByIds(ids);
        return MessageUtil.success("删除成功!");
    }

    @ApiOperation("删除用户")
    @GetMapping("deleteById")
    public Message deleteById(long id){
        userservice.deleteByid(id);
        return MessageUtil.success("删除成功!");
    }

    @ApiOperation("修改用户信息")
    @PostMapping("updateUser")
    public Message updateUser(@RequestBody User user){
        userservice.updateUser(user);
        return MessageUtil.success("修改成功!");
    }


    @ApiOperation("用户登录接口")
    @PostMapping("login")
    public Message login(@RequestBody UserVm userVm) {
        //1验证身份
        //2.产生一个token并缓存起来，
        //3.返回
        //模拟数据
        Map<String,String> map = new HashMap<>();
        map.put("token","admin-token");
        return MessageUtil.success(map);
    }


    @ApiOperation("用户退出登录接口")
    @PostMapping("logout")
    public Message logout(){
        //移除缓存中的token
        //其他操作
        return MessageUtil.success("退出成功");
    }

    @ApiOperation("根据token查询用户信息")
    @GetMapping("info")
    public Message info(String token){
        //通过token查询数据
        UserExtend userExtend = userservice.extendFindById(1L);
        return MessageUtil.success(userExtend);
    }
}

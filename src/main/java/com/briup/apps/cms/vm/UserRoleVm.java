package com.briup.apps.cms.vm;

import java.util.List;

/**
 * Copyright (C) @2019 qiangzunhui@126.com
 *
 * @author zunhui
 * @version 1.0
 * @ClassName UserRoleVm
 * @date 2019-11-20 09:26
 * @description 用户设置角色类
 */
public class UserRoleVm {

    private Long id;
    private List<Long> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getRoles() {
        return roles;
    }

    public void setRoles(List<Long> roles) {
        this.roles = roles;
    }
}


package com.briup.apps.cms.bean.extend;

import com.briup.apps.cms.bean.Role;
import com.briup.apps.cms.bean.User;

import java.util.List;

/**
 * Copyright (C) @2019 zunhui Qiang_zunhui@tom.com
 *
 * @author zunhui
 * @version 1.0
 * @ClassName UserExtend
 * @date 2019-11-18 13:49
 * @description 用户拓展类
 */
public class UserExtend extends User {

    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}

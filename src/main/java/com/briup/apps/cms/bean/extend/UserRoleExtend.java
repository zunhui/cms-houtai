package com.briup.apps.cms.bean.extend;

import com.briup.apps.cms.bean.Role;
import com.briup.apps.cms.bean.User;
import com.briup.apps.cms.bean.UserRole;

import java.util.List;

/**
 * Copyright (C) @2019 zunhui Qiang_zunhui@tom.com
 *
 * @author zunhui
 * @version 1.0
 * @ClassName UserRoleExtend
 * @date 2019-11-18 09:43
 * @description 用户角色拓展类
 */
public class UserRoleExtend extends UserRole {

    private List<User> users;
    private List<Role> roles;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}

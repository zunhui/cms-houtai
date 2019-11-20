package com.briup.apps.cms.bean.extend;

import com.briup.apps.cms.bean.Privilege;
import com.briup.apps.cms.bean.Role;
import com.briup.apps.cms.bean.RolePrivilege;

import java.util.List;

/**
 * Copyright (C) @2019 zunhui Qiang_zunhui@tom.com
 *
 * @author zunhui
 * @version 1.0
 * @ClassName RolePrivilegeExtend
 * @date 2019-11-18 09:45
 * @description 角色权限拓展类
 */
public class RolePrivilegeExtend extends RolePrivilege {

    private List<Role> roles;
    private List<Privilege> privileges;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }
}


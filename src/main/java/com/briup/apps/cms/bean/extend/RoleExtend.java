package com.briup.apps.cms.bean.extend;

import com.briup.apps.cms.bean.Privilege;
import com.briup.apps.cms.bean.Role;

import java.util.List;

/**
 * Copyright (C) @2019 qiangzunhui@126.com
 *
 * @author zunhui
 * @version 1.0
 * @ClassName RoleExtend
 * @date 2019-11-19 10:11
 * @description 角色扩展类
 */
public class RoleExtend extends Role {

    List<Privilege> privileges;

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }
}

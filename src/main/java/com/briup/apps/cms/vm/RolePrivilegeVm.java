package com.briup.apps.cms.vm;

import java.util.List;

/**
 * Copyright (C) @2019 qiangzunhui@126.com
 *
 * @author zunhui
 * @version 1.0
 * @ClassName RolePrivilegeVm
 * @date 2019-11-20 16:01
 * @description 角色权限设置类
 */
public class RolePrivilegeVm {

    private Long id;
    private String name;
    private List<Long> privileges;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Long> privileges) {
        this.privileges = privileges;
    }
}

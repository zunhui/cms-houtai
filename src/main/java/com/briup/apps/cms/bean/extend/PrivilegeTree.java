package com.briup.apps.cms.bean.extend;

import com.briup.apps.cms.bean.Privilege;

import java.util.List;

/**
 * Copyright (C) @2019 qiangzunhui@126.com
 *
 * @author zunhui
 * @version 1.0
 * @ClassName PrivilegeTree
 * @date 2019-11-19 14:00
 * @description 权限树类
 */
public class PrivilegeTree extends Privilege {

    private List<Privilege> children;

    public List<Privilege> getChildren() {
        return children;
    }

    public void setChildren(List<Privilege> children) {
        this.children = children;
    }

}

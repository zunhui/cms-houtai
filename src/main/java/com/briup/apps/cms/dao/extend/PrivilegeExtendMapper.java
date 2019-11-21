package com.briup.apps.cms.dao.extend;

import com.briup.apps.cms.bean.Privilege;
import com.briup.apps.cms.dao.PrivilegeMapper;
import com.briup.apps.cms.vm.PrivilegeTree;

import java.util.List;

/**
 * Copyright (C) @2019 qiangzunhui@126.com
 *
 * @author zunhui
 * @version 1.0
 * @ClassName PrivilegeExtendMapper
 * @date 2019-11-19 09:04
 * @description 权限拓展接口
 */
public interface PrivilegeExtendMapper extends PrivilegeMapper {

    List<Privilege> findAllNoParentId();

    List<Privilege> findByParentId(Long parentId);

    List<Privilege> findByUserId(Long userId);

    List<Privilege> selectByRoleId(Long role_id);

    ///查询权限树
    List<PrivilegeTree> findPrivilegeTree();
}


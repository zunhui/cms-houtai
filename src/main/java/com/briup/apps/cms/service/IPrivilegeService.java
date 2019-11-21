package com.briup.apps.cms.service;

import com.briup.apps.cms.bean.Privilege;
import com.briup.apps.cms.utils.CustomerException;
import com.briup.apps.cms.vm.PrivilegeTree;

import java.util.List;

/**
 * Copyright (C) @2019 qiangzunhui@126.com
 *
 * @author zunhui
 * @version 1.0
 * @ClassName IPrivilegeService
 * @date 2019-11-19 08:50
 * @description 权限接口
 */
public interface IPrivilegeService {

     List<Privilege> findByParentId(Long id);

     void saveOrUpdate(Privilege privilege)throws CustomerException;

     //查询权限树
     List<PrivilegeTree> findPrivilegeTree();

     List<Privilege> findByUserId(long userId);
}

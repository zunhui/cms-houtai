package com.briup.apps.cms.dao.extend;

import com.briup.apps.cms.dao.RolePrivilegeMapper;
import com.briup.apps.cms.utils.CustomerException;

/**
 * Copyright (C) @2019 qiangzunhui@126.com
 *
 * @author zunhui
 * @version 1.0
 * @ClassName RolePrivilegeExtendMapper
 * @date 2019-11-20 10:30
 * @description 角色权限扩展
 */
public interface RolePrivilegeExtendMapper extends RolePrivilegeMapper {

    void deleteByPrivilegeId(Long privilege_id)throws CustomerException;

}

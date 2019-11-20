package com.briup.apps.cms.dao.extend;

import com.briup.apps.cms.bean.Role;
import com.briup.apps.cms.bean.extend.RoleExtend;
import com.briup.apps.cms.dao.RoleMapper;

import java.util.List;

/**
 * Copyright (C) @2019 qiangzunhui@126.com
 *
 * @author zunhui
 * @version 1.0
 * @ClassName RoleExtendMapper
 * @date 2019-11-18 19:03
 * @description 角色拓展接口
 */
public interface RoleExtendMapper extends RoleMapper {

    List<Role> selectByUserId(long id);

    Role selectByName(String name);

    List<RoleExtend> cascadePrivilegeFindAll();

}

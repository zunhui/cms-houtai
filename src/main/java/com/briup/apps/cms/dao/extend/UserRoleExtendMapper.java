package com.briup.apps.cms.dao.extend;

import com.briup.apps.cms.dao.UserRoleMapper;

/**
 * Copyright (C) @2019 qiangzunhui@126.com
 *
 * @author zunhui
 * @version 1.0
 * @ClassName UserRoleExtendMapper
 * @date 2019-11-20 09:17
 * @description 用户角色拓展类
 */
public interface UserRoleExtendMapper extends UserRoleMapper {

    void deleteByRoleId(Long role_id);

}

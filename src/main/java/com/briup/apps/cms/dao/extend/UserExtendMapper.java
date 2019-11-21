package com.briup.apps.cms.dao.extend;

import com.briup.apps.cms.bean.User;
import com.briup.apps.cms.bean.extend.UserExtend;
import com.briup.apps.cms.dao.UserMapper;

import java.util.List;

/**
 * Copyright (C) @2019 qiangzunhui@126.com
 *
 * @author zunhui
 * @version 1.0
 * @ClassName UserExtendMapper
 * @date 2019-11-18 18:56
 * @description 用户拓展接口
 */
public interface UserExtendMapper extends UserMapper {

    UserExtend selectById(long id);

    List<UserExtend> findExtendAll();

    User selectByName(String username);

    List<Long> selectByUserId(Long id);
}

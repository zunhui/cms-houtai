package com.briup.apps.cms.service.impl;

import com.briup.apps.cms.bean.Privilege;
import com.briup.apps.cms.bean.PrivilegeExample;
import com.briup.apps.cms.dao.PrivilegeMapper;
import com.briup.apps.cms.dao.extend.PrivilegeExtendMapper;
import com.briup.apps.cms.service.IPrivilegeService;
import com.briup.apps.cms.utils.CustomerException;
import com.briup.apps.cms.vm.PrivilegeTree;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (C) @2019 qiangzunhui@126.com
 *
 * @author zunhui
 * @version 1.0
 * @ClassName PrivilegeServiceImpl
 * @date 2019-11-19 08:54
 * @description 权限接口实现类
 */
@Service
public class PrivilegeServiceImpl implements IPrivilegeService {

    @Resource
    private PrivilegeExtendMapper privilegeExtendMapper;
    @Resource
    private PrivilegeMapper privilegeMapper;

    @Override
    public List<Privilege> findByParentId(Long id) {
        if (id==null){
            List<Privilege> noParentIdList = privilegeExtendMapper.findAllNoParentId();
            return noParentIdList;
        }else {
            List<Privilege> list = privilegeExtendMapper.findByParentId(id);
            return list;
        }
    }

    @Override
    public void saveOrUpdate(Privilege privilege) throws CustomerException {
        if (privilege.getId() != null) {
            privilegeMapper.updateByPrimaryKey(privilege);
        } else {
            privilegeMapper.insert(privilege);
        }
    }

    @Override
    public List<PrivilegeTree> findPrivilegeTree() {
        return privilegeExtendMapper.findPrivilegeTree();
    }

    @Override
    public List<Privilege> findByUserId(long userId) {
        return privilegeExtendMapper.findByUserId(userId);
    }
}

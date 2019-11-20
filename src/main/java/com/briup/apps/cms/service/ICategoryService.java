package com.briup.apps.cms.service;

import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.extend.CategoryExtend;
import com.briup.apps.cms.utils.CustomerException;

import java.util.List;

/**
 * Copyright (C) @2019 zunhui Qiang_zunhui@tom.com
 *
 * @author zunhui
 * @version 1.0
 * @ClassName ICategoryService
 * @date 2019-11-14 11:47
 * @description TODO
 */
public interface ICategoryService {

    List<Category> findAll();
    //根据栏目及其父栏目
    List<CategoryExtend> cacadeFindAll();

    void saveOrUpdate(Category category) throws CustomerException;

    void deleteByID(long id) throws CustomerException;

    void batchDeleteById(long[] ids)throws CustomerException;
}

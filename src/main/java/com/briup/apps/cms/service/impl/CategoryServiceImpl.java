package com.briup.apps.cms.service.impl;

import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.CategoryExample;
import com.briup.apps.cms.bean.extend.CategoryExtend;
import com.briup.apps.cms.config.CustomerExceptionHandler;
import com.briup.apps.cms.dao.CategoryMapper;
import com.briup.apps.cms.dao.extend.CategoryExtendMapper;
import com.briup.apps.cms.service.ICategoryService;
import com.briup.apps.cms.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (C) @2019 zunhui Qiang_zunhui@tom.com
 *
 * @author zunhui
 * @version 1.0
 * @ClassName CategoryServiceImpl
 * @date 2019-11-14 13:14
 * @description 类
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private CategoryExtendMapper categoryExtendMapper;

    @Override
    public List<Category> findAll() {

        return categoryMapper.selectByExample(new CategoryExample());
    }

    @Override
    public List<CategoryExtend> cacadeFindAll() {
        return categoryExtendMapper.cacadeFindAll();
    }


    @Override
    public void saveOrUpdate(Category category) throws CustomerException {
        if(category.getId()!=null){
            categoryMapper.updateByPrimaryKey(category);
        }else {
            CategoryExample example = new CategoryExample();
            example.createCriteria().andNameEqualTo(category.getName());
            List<Category> list = categoryMapper.selectByExample(example);
            if (list.size()>0){
                throw new CustomerException("文章栏目已存在!");
            }
            categoryMapper.insert(category);
        }
    }

    @Override
    public void deleteByID(long id) throws CustomerException {
        Category category = categoryMapper.selectByPrimaryKey(id);
        if (category==null){
            throw new CustomerException("栏目不存在");
        }else {
            categoryMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void batchDeleteById(long[] ids) throws CustomerException {
        if (ids.length>0&&ids!=null){
            for (long id:ids) {
                deleteByID(id);
            }
        }
    }
}

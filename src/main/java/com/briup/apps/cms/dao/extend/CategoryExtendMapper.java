package com.briup.apps.cms.dao.extend;

import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.extend.CategoryExtend;
import com.briup.apps.cms.dao.CategoryMapper;

import java.util.List;

/**
 * Copyright (C) @2019 zunhui Qiang_zunhui@tom.com
 *
 * @author zunhui
 * @version 1.0
 * @ClassName CategoryMapper
 * @date 2019-11-16 11:14
 * @description TODO
 */
public interface CategoryExtendMapper extends CategoryMapper {

    Category selectByParentId(long parent_id);

    List<CategoryExtend> cacadeFindAll();

}

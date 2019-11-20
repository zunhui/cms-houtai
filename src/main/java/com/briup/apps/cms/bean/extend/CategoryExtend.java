package com.briup.apps.cms.bean.extend;

import com.briup.apps.cms.bean.Category;

/**
 * Copyright (C) @2019 zunhui Qiang_zunhui@tom.com
 *
 * @author zunhui
 * @version 1.0
 * @ClassName CategoryExtend
 * @date 2019-11-16 11:06
 * @description 类
 */
public class CategoryExtend extends Category{

    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

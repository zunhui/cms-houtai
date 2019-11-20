package com.briup.apps.cms.dao.extend;

import com.briup.apps.cms.bean.extend.ArticleExtend;

import java.util.List;

/**
 * Copyright (C) @2019 zunhui Qiang_zunhui@tom.com
 *
 * @author zunhui
 * @version 1.0
 * @ClassName ArticleExtendMapper
 * @date 2019-11-12 21:14
 * @description TODO
 */
public interface ArticleExtendMapper{

    List<ArticleExtend> selectAll();

    ArticleExtend selectById(long id);

}

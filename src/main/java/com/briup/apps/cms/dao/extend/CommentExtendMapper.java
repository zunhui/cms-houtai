package com.briup.apps.cms.dao.extend;

import com.briup.apps.cms.bean.Comment;
import com.briup.apps.cms.bean.extend.CommentExtend;

import java.util.List;

/**
 * Copyright (C) @2019 zunhui Qiang_zunhui@tom.com
 *
 * @author zunhui
 * @version 1.0
 * @ClassName CommentExtendMapper
 * @date 2019-11-12 22:05
 * @description TODO
 */
public interface CommentExtendMapper {

    List<Comment> selectByArticleId(long article_id);

    //查询所有评论
    List<CommentExtend> findAll();

}

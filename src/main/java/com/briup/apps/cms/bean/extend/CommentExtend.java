package com.briup.apps.cms.bean.extend;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.Comment;
import com.briup.apps.cms.bean.User;

/**
 * Copyright (C) @2019 zunhui Qiang_zunhui@tom.com
 *
 * @author zunhui
 * @version 1.0
 * @ClassName CommentExtend
 * @date 2019-11-16 21:53
 * @description 评论拓展类
 */
public class CommentExtend extends Comment {

    private User uesr;
    private ArticleExtend articleExtend;

    public User getUesr() {
        return uesr;
    }

    public void setUesr(User uesr) {
        this.uesr = uesr;
    }

    public ArticleExtend getArticleExtend() {
        return articleExtend;
    }

    public void setArticleExtend(ArticleExtend articleExtend) {
        this.articleExtend = articleExtend;
    }
}

package com.briup.apps.cms.service;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.ArticleExample;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.utils.CustomerException;

import java.util.List;

public interface IArticleService {
    List<Article> findAll();

    List<ArticleExtend> cascadeFindAll();

    ArticleExtend findById(long id);

    //删除
    void deleteByID(long id) throws CustomerException;

    void saveOrUpdate(Article article) throws CustomerException;
}

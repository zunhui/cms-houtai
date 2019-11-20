package com.briup.apps.cms.service.impl;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.ArticleExample;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.dao.ArticleMapper;
import com.briup.apps.cms.dao.extend.ArticleExtendMapper;
import com.briup.apps.cms.service.IArticleService;
import com.briup.apps.cms.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @program: cms_jd1908
 * @description: 文章的业务实现类
 * @author: charles
 * @create: 2019-11-12 14:59
 **/
@Service
public class ArticleServiceImpl implements IArticleService {



    @Resource
    private ArticleExtendMapper articleExtendMapper;
    @Resource
    private ArticleMapper articleMapper;
    @Override
    public List<Article> findAll() {

        return articleMapper.selectByExample(new ArticleExample());
    }

    @Override
    public List<ArticleExtend> cascadeFindAll() {

        return articleExtendMapper.selectAll();
    }

    @Override
    public ArticleExtend findById(long id) {

        return articleExtendMapper.selectById(id);
    }

    @Override
    public void deleteByID(long id) throws CustomerException {
        Article article = articleMapper.selectByPrimaryKey(id);
        if (article!=null){
            articleMapper.deleteByPrimaryKey(id);
        }else {
            throw new CustomerException("文章不存在!");
        }
    }

    //保存或更新article
    @Override
    public void saveOrUpdate(Article article) throws CustomerException{
        if(article.getId()!=null){
            articleMapper.updateByPrimaryKey(article);
        }else {
            ArticleExample articleExample = new ArticleExample();
            articleExample.createCriteria().andTitleEqualTo(article.getTitle());
            List<Article> list = articleMapper.selectByExample(articleExample);
            if(list.size()>0){
                throw new CustomerException("文章标题不能重复!");
            }
            //初始化
            article.setStatus(ArticleExtend.STATUS_UNCHECK);
            article.setThumpUp(0l);
            article.setThumpDown(0l);
            article.setPublishTime(new Date().getTime());
            article.setReadTimes(0l);
            articleMapper.insert(article);
        }
    }

}

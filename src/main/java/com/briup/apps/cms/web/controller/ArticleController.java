package com.briup.apps.cms.web.controller;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.service.IArticleService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: cms_jd1908
 * @description: 文章控制器类
 * @author: charles
 * @create: 2019-11-12 15:00
 **/
@RestController
//@Api(tags = "文章相关接口")
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @GetMapping("findAll")
    public Message findAll(){
        List<Article> list = articleService.findAll();
        return MessageUtil.success(list);
    }

    @GetMapping("cacadeFindAll")
    public Message cacadeFindAll(){
        List<ArticleExtend> list = articleService.cascadeFindAll();
        return MessageUtil.success(list);
    }

    @GetMapping("findById")
    public Message findById(long id){
        ArticleExtend articleExtend = articleService.findById(id);
        return MessageUtil.success(articleExtend);
    }

    //更新 保存
    @ApiOperation("保存或更新")
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(
            @ApiParam(value = "编号") @RequestParam(value = "id",required = false)Long id,
            @ApiParam(value = "标题",required = true) @RequestParam(value = "title")String title,
            @ApiParam(value = "内容",required = true) @RequestParam(value = "content")String content,
            @ApiParam(value = "源内容",required = true) @RequestParam(value = "source",required = false)String source,
            @ApiParam(value = "栏目id",required = true) @RequestParam(value = "categoryId")Long categoryId,
            @ApiParam(value = "作者id",required = true) @RequestParam(value = "authorId",required = false)Long authorId
    ){
        Article article = new Article();
        article.setId(id);
        article.setTitle(title);
        article.setContent(content);
        article.setSource(source);
        article.setCategoryId(categoryId);
        article.setAuthorId(authorId);
        articleService.saveOrUpdate(article);
        return MessageUtil.success("更新成功!");
    }
    @ApiOperation("根据id删除文章")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id",value = "编号",required = true,paramType = "query")
    )
    @GetMapping("deleteById")
    public Message deleteById(long id) {
        articleService.deleteByID(id);
        return MessageUtil.success("删除成功");
    }
}
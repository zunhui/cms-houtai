package com.briup.apps.cms.web.controller;

import com.briup.apps.cms.bean.Comment;
import com.briup.apps.cms.bean.extend.CommentExtend;
import com.briup.apps.cms.service.ICommentService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Copyright (C) @2019 zunhui Qiang_zunhui@tom.com
 *
 * @author zunhui
 * @version 1.0
 * @ClassName CommentController
 * @date 2019-11-17 13:52
 * @description 类
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private ICommentService service;

    @ApiOperation("查询所有评论")
    @GetMapping("findAll")
    public Message findAll(){
        List<CommentExtend> list = service.findAll();
        return MessageUtil.success(list);
    }

    @ApiOperation("根据id查询评论")
    @GetMapping("selectById")
    public Message selectById(long id){
        return MessageUtil.success(service.selectById(id));
    }

    @ApiOperation("删除评论")
    @GetMapping("deleteById")
    public Message deleteById(long id){
        service.deleteById(id);
        return MessageUtil.success("删除成功!");
    }

    @ApiOperation("批量删除评论")
    @PostMapping("batchDeleteById")
    public Message batchDeleteById(long[] ids){
        service.batchDeleteById(ids);
        return MessageUtil.success("删除成功!");
    }
    @ApiOperation("审核评论")
    @PostMapping("auditById")
    public Message auditById(@RequestBody Comment comment){
        service.auditById(comment);
        return MessageUtil.success("操作成功!");
    }
}

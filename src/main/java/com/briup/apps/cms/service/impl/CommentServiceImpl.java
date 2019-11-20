package com.briup.apps.cms.service.impl;

import com.briup.apps.cms.bean.Comment;
import com.briup.apps.cms.bean.extend.CommentExtend;
import com.briup.apps.cms.dao.CommentMapper;
import com.briup.apps.cms.dao.extend.CommentExtendMapper;
import com.briup.apps.cms.service.ICommentService;
import com.briup.apps.cms.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (C) @2019 zunhui Qiang_zunhui@tom.com
 *
 * @author zunhui
 * @version 1.0
 * @ClassName CommentServiceImpl
 * @date 2019-11-17 13:41
 * @description 类
 */
@Service
public class CommentServiceImpl implements ICommentService {

    @Resource
    private CommentMapper commentMapper;
    @Resource
    private CommentExtendMapper commentExtendMapper;

    @Override
    public List<CommentExtend> findAll() {
        return commentExtendMapper.findAll();
    }

    @Override
    public Comment selectById(long id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteById(long id) throws CustomerException {
        Comment comment = commentMapper.selectByPrimaryKey(id);
        if (comment==null){
            throw new CustomerException("该评论已删除");
        }else {
            commentMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void batchDeleteById(long[] ids) throws CustomerException {
        if (ids==null||ids.length<=0){
            throw new CustomerException("请选择要删除的评论");
        }else {
            for (long id:ids){
                deleteById(id);
            }
        }
    }
    //审核评论
    @Override
    public void auditById(Comment comment) throws CustomerException {
        commentMapper.updateByPrimaryKey(comment);
    }
}

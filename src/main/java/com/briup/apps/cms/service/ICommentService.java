package com.briup.apps.cms.service;

import com.briup.apps.cms.bean.Comment;
import com.briup.apps.cms.bean.extend.CommentExtend;
import com.briup.apps.cms.utils.CustomerException;

import java.util.List;

/**
 * Copyright (C) @2019 zunhui Qiang_zunhui@tom.com
 *
 * @author zunhui
 * @version 1.0
 * @ClassName ICommentService
 * @date 2019-11-17 13:38
 * @description TODO
 */
public interface ICommentService {

    List<CommentExtend> findAll();

    Comment selectById(long id);

    void deleteById(long id)throws CustomerException;

    void batchDeleteById(long[] ids)throws CustomerException;

    void auditById(Comment comment)throws CustomerException;


}

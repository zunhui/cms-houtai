package com.briup.apps.cms.web.controller;

import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.extend.CategoryExtend;
import com.briup.apps.cms.service.ICategoryService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/category")
public class CateGoryController {

    @Autowired
    private ICategoryService service;

    @ApiOperation("查询所有的栏目信息")
    @GetMapping("findAll")
    public Message findAll(){
        List<Category> list = service.findAll();
        return MessageUtil.success(list);
    }

    @ApiOperation("查询所有的栏目及其父栏目信息")
    @GetMapping("cacadeFindAll")
    public Message cacadeFindAll(){
        List<CategoryExtend> list = service.cacadeFindAll();
        return MessageUtil.success(list);
    }

    //更新 保存
    @ApiOperation(value = "保存或更新",
                  notes = "保存时无需传递id，如果传递id后台认为你要完成更新操作，将后台数据更新为传递的数据" )
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(@RequestBody Category category){
        service.saveOrUpdate(category);
        return MessageUtil.success("更新成功!");
    }

    @ApiOperation("根据id删除栏目")
    @GetMapping("deleteById")
    public Message deleteById(
            @ApiParam(value = "栏目",required = true) @RequestParam(value = "id")long id) {
        service.deleteByID(id);
        return MessageUtil.success("删除成功!");
    }
    @ApiOperation("根据id批量删除栏目")
    @PostMapping("batchDeleteById")
    public Message batchDeleteById(@RequestBody() long[] ids) {
        service.batchDeleteById(ids);
        return MessageUtil.success("删除成功!");
    }


}


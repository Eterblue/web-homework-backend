package com.hit.webhomework.service;

import com.hit.webhomework.domain.ResponseResult;
import com.hit.webhomework.domain.entity.Clazz;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;

/**
* @author sardinary
* @description 针对表【clazz】的数据库操作Service
* @createDate 2024-05-07 10:25:39
*/
public interface ClazzService extends IService<Clazz> {

    ResponseResult getList(String name, Integer page, Integer pageSize);
}

package com.hit.webhomework.service;

import com.hit.webhomework.domain.ResponseResult;
import com.hit.webhomework.domain.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author sardinary
* @description 针对表【course】的数据库操作Service
* @createDate 2024-05-07 20:52:36
*/
public interface CourseService extends IService<Course> {

    ResponseResult getList(String id, String name, Integer page, Integer pageSize);
}

package com.hit.webhomework.service;

import com.hit.webhomework.domain.ResponseResult;
import com.hit.webhomework.domain.entity.CourseEmp;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author sardinary
* @description 针对表【course_emp】的数据库操作Service
* @createDate 2024-05-07 20:51:13
*/
public interface CourseEmpService extends IService<CourseEmp> {

    ResponseResult courseEmpList(String courseId, String courseName, String empName, Integer page, Integer pageSize);
}

package com.hit.webhomework.service;

import com.hit.webhomework.domain.ResponseResult;
import com.hit.webhomework.domain.entity.Stu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author sardinary
* @description 针对表【stu】的数据库操作Service
* @createDate 2024-05-06 20:07:40
*/
public interface StuService extends IService<Stu> {
    ResponseResult selectAll(String name,
                                    String id,
                                    Integer education,
                                    Integer clazz,
                                    Integer page,
                                    Integer pageSize);
}

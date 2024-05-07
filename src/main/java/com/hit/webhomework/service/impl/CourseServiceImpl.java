package com.hit.webhomework.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hit.webhomework.domain.ResponseResult;
import com.hit.webhomework.domain.entity.Course;
import com.hit.webhomework.domain.response.PageResponse;
import com.hit.webhomework.service.CourseService;
import com.hit.webhomework.mapper.CourseMapper;
import org.springframework.stereotype.Service;

/**
* @author sardinary
* @description 针对表【course】的数据库操作Service实现
* @createDate 2024-05-07 20:52:36
*/
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course>
    implements CourseService{

    @Override
    public ResponseResult getList(String id, String name, Integer page, Integer pageSize) {
        LambdaQueryWrapper<Course> queryWrapper = new LambdaQueryWrapper<Course>()
                .like(!StrUtil.isBlankIfStr(id), Course::getId, id)
                .like(!StrUtil.isBlankIfStr(name), Course::getName, name);
        Page<Course> coursePage = new Page<>(page, pageSize);
        page(coursePage, queryWrapper);
        PageResponse pageResponse = new PageResponse(coursePage.getRecords(), coursePage.getTotal());
        return ResponseResult.ok(pageResponse);
    }
}





package com.hit.webhomework.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hit.webhomework.domain.ResponseResult;
import com.hit.webhomework.domain.entity.Course;
import com.hit.webhomework.domain.entity.CourseEmp;
import com.hit.webhomework.domain.entity.Emp;
import com.hit.webhomework.domain.response.CourseEmpListResponse;
import com.hit.webhomework.domain.response.PageResponse;
import com.hit.webhomework.service.CourseEmpService;
import com.hit.webhomework.mapper.CourseEmpMapper;
import com.hit.webhomework.service.CourseService;
import com.hit.webhomework.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author sardinary
* @description 针对表【course_emp】的数据库操作Service实现
* @createDate 2024-05-07 20:51:13
*/
@Service
public class CourseEmpServiceImpl extends ServiceImpl<CourseEmpMapper, CourseEmp>
    implements CourseEmpService{
    @Autowired
    private CourseService courseService;
    @Autowired
    private EmpService empService;

    @Override
    public ResponseResult courseEmpList(String courseId, String courseName, String empName, Integer page, Integer pageSize) {
        List<String> courseIds = new LambdaQueryChainWrapper<>(courseService.getBaseMapper())
                .like(!StrUtil.isBlankIfStr(courseName), Course::getName, courseName)
                .like(!StrUtil.isBlankIfStr(courseId), Course::getId, courseId)
                .list()
                .stream()
                .map(Course::getId)
                .collect(Collectors.toList());
        List<Integer> empIds = new LambdaQueryChainWrapper<>(empService.getBaseMapper())
                .like(!StrUtil.isBlankIfStr(empName), Emp::getName, empName)
                .list()
                .stream()
                .map(Emp::getId)
                .collect(Collectors.toList());

        if (courseIds.isEmpty() || empIds.isEmpty()) {
            PageResponse pageResponse = new PageResponse(null, 0L);
            return ResponseResult.ok(pageResponse);
        }
        List<CourseEmpListResponse> responses = new LambdaQueryChainWrapper<>(baseMapper)
                .in(!courseIds.isEmpty(),CourseEmp::getCourseId, courseIds)
                .in(!empIds.isEmpty(),CourseEmp::getEmpId, empIds)
                .list()
                .stream()
                .map(ce -> {
                    CourseEmpListResponse courseEmpListResponse = new CourseEmpListResponse();
                    String cName = courseService.getById(ce.getCourseId()).getName();
                    String eName = empService.getById(ce.getEmpId()).getName();
                    courseEmpListResponse.setCourseName(cName);
                    courseEmpListResponse.setEmpName(eName);
                    courseEmpListResponse.setCourseId(ce.getCourseId());
                    courseEmpListResponse.setEmpId(ce.getEmpId());
                    return courseEmpListResponse;
                })
                .collect(Collectors.toList());
        List<CourseEmpListResponse> record = responses.stream()
                .skip((long) pageSize * (page - 1))
                .limit(pageSize)
                .collect(Collectors.toList());
        PageResponse pageResponse = new PageResponse(record, (long) responses.size());
        return ResponseResult.ok(pageResponse);
    }
}





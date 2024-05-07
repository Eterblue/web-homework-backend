package com.hit.webhomework.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hit.webhomework.domain.ResponseResult;
import com.hit.webhomework.domain.entity.Course;
import com.hit.webhomework.domain.entity.CourseEmp;
import com.hit.webhomework.service.CourseEmpService;
import com.hit.webhomework.service.CourseService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseEmpService courseEmpService;
    @GetMapping
    public ResponseResult getList(
            String id,
            String name,
            @NotNull Integer page,
            @NotNull Integer pageSize) {
        return courseService.getList(id,name,page,pageSize);
    }

    @GetMapping("/listall")
    public ResponseResult getAll() {
        return ResponseResult.ok(courseService.list());
    }

    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable @NotNull String id){
        courseService.removeById(id);
        return ResponseResult.ok();
    }


    @PostMapping
    public ResponseResult add(@RequestBody Course course){
        courseService.save(course);
        return ResponseResult.ok();
    }

    @GetMapping("/{id}")
    public ResponseResult getById(@PathVariable @NotNull String id){
        return ResponseResult.ok(courseService.getById(id));
    }

    @PutMapping
    public ResponseResult update(@RequestBody @Validated Course course){
        courseService.updateById(course);
        return ResponseResult.ok();
    }

    @GetMapping("/ce")
    public ResponseResult courseEmpList(
            String courseId,
            String courseName,
            String empName,
            @NotNull Integer page,
            @NotNull Integer pageSize) {
        return courseEmpService.courseEmpList(courseId,courseName,empName,page,pageSize);
    }

    @PostMapping("/ce")
    public ResponseResult addCourseEmp(@RequestBody CourseEmp courseEmp){
        courseEmpService.save(courseEmp);
        return ResponseResult.ok();
    }

    @DeleteMapping("/ce")
    public ResponseResult deleteCourseEmp(@RequestBody CourseEmp courseEmp){
        LambdaQueryWrapper<CourseEmp> queryWrapper = new LambdaQueryWrapper<CourseEmp>()
                .eq(CourseEmp::getCourseId, courseEmp.getCourseId())
                .eq(CourseEmp::getEmpId, courseEmp.getEmpId());
        courseEmpService.remove(queryWrapper);
        return ResponseResult.ok();
    }


}

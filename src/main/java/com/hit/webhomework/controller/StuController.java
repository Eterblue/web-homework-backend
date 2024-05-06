package com.hit.webhomework.controller;

import com.hit.webhomework.domain.ResponseResult;
import com.hit.webhomework.domain.entity.Stu;
import com.hit.webhomework.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stu")
public class StuController {
    @Autowired
    private StuService stuService;

    @GetMapping
    public ResponseResult selectAll(String name,
                                    String id,
                                    Integer education,
                                    Integer clazz,
                                    Integer page,
                                    Integer pageSize) {

        return stuService.selectAll(name,id,education,clazz,page,pageSize);
    }

    @DeleteMapping
    public ResponseResult deleteStu(@RequestBody List<String> stuIds){
        stuService.removeByIds(stuIds);
        return ResponseResult.ok();
    }

    @PostMapping
    public ResponseResult addStu(@RequestBody Stu stu){
        stuService.save(stu);
        return ResponseResult.ok();
    }

    @GetMapping("/{id}")
    public ResponseResult getStu(@PathVariable Long id){
        return ResponseResult.ok(stuService.getById(id));
    }

    @PutMapping
    public ResponseResult updateStu(@RequestBody Stu stu){
        stuService.updateById(stu);
        return ResponseResult.ok();
    }

}

package com.hit.webhomework.controller;

import com.hit.webhomework.domain.ResponseResult;
import com.hit.webhomework.domain.entity.Dept;
import com.hit.webhomework.domain.entity.Emp;
import com.hit.webhomework.domain.request.AddDeptRequest;
import com.hit.webhomework.domain.request.AddEmpRequest;
import com.hit.webhomework.domain.request.UpdateDeptRequest;
import com.hit.webhomework.domain.request.UpdateEmpRequest;
import com.hit.webhomework.service.DeptService;
import com.hit.webhomework.service.EmpService;
import com.hit.webhomework.utils.BeanCopyUtils;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping
    public ResponseResult getList(
            String name,
            Integer gender,
            Long startTime,
            Long endTime,
            @NotNull Integer page,
            @NotNull Integer pageSize) {
        return empService.getList(name,gender,startTime,endTime,page,pageSize);
    }

    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable @NotNull Long id){
        empService.removeById(id);
        return ResponseResult.ok();
    }

    @PostMapping
    public ResponseResult add(@RequestBody @Validated AddEmpRequest addEmpRequest){
        Emp emp = BeanCopyUtils.copyBean(addEmpRequest, Emp.class);
        empService.save(emp);
        return ResponseResult.ok();
    }

    @GetMapping("/{id}")
    public ResponseResult getById(@PathVariable @NotNull Long id){
        return ResponseResult.ok(empService.getById(id));
    }

    @PutMapping
    public ResponseResult update(@RequestBody @Validated UpdateEmpRequest updateEmpRequest){
        Emp emp = BeanCopyUtils.copyBean(updateEmpRequest, Emp.class);
        empService.updateById(emp);
        return ResponseResult.ok();
    }

}

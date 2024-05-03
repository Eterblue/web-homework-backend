package com.hit.webhomework.controller;

import com.hit.webhomework.domain.ResponseResult;
import com.hit.webhomework.domain.entity.Dept;
import com.hit.webhomework.domain.request.AddDeptRequest;
import com.hit.webhomework.domain.request.UpdateDeptRequest;
import com.hit.webhomework.service.DeptService;
import com.hit.webhomework.utils.BeanCopyUtils;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping
    public ResponseResult getList(){
        return ResponseResult.ok(deptService.list());
    }

    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable @NotNull Long id){
        deptService.removeById(id);
        return ResponseResult.ok();
    }

    @PostMapping
    public ResponseResult add(@RequestBody @Validated AddDeptRequest addDeptRequest){
        Dept dept = BeanCopyUtils.copyBean(addDeptRequest, Dept.class);
        deptService.save(dept);
        return ResponseResult.ok();
    }

    @GetMapping("/{id}")
    public ResponseResult getById(@PathVariable @NotNull Long id){
        return ResponseResult.ok(deptService.getById(id));
    }

    @PutMapping
    public ResponseResult update(@RequestBody @Validated UpdateDeptRequest updateDeptRequest){
        Dept dept = BeanCopyUtils.copyBean(updateDeptRequest, Dept.class);
        deptService.updateById(dept);
        return ResponseResult.ok();
    }

}

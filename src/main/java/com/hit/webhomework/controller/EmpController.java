package com.hit.webhomework.controller;

import com.hit.webhomework.domain.ResponseResult;
import com.hit.webhomework.domain.entity.Emp;
import com.hit.webhomework.domain.request.*;
import com.hit.webhomework.service.EmpService;
import com.hit.webhomework.utils.BeanCopyUtils;
import com.hit.webhomework.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping("/myinfo")
    public ResponseResult myinfo(HttpServletRequest request) {
        String token = request.getHeader("token");
        Object o = JwtUtils.parsePayload(token).get("id");
        Integer id = Integer.valueOf(o.toString());
        return ResponseResult.ok(empService.getById(id));
    }

    @GetMapping
    public ResponseResult getList(
            String name,
            Integer gender,
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date startTime,
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime,
            @NotNull Integer page,
            @NotNull Integer pageSize) {
        return empService.getList(name,gender,startTime,endTime,page,pageSize);
    }


    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable @NotNull Long id){
        empService.removeById(id);
        return ResponseResult.ok();
    }


    @DeleteMapping
    public ResponseResult deleteBatch(@RequestBody @NotEmpty List<Long> empIds){
        empService.removeBatchByIds(empIds);
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

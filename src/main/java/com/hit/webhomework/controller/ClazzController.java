package com.hit.webhomework.controller;

import com.hit.webhomework.domain.ResponseResult;
import com.hit.webhomework.domain.entity.Clazz;
import com.hit.webhomework.service.ClazzService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/clazz")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    @GetMapping
    public ResponseResult getList(
            String name,
            @NotNull Integer page,
            @NotNull Integer pageSize) {
        return clazzService.getList(name,page,pageSize);
    }

    @GetMapping("/listall")
    public ResponseResult getAll() {
        return ResponseResult.ok(clazzService.list());
    }

    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable @NotNull Long id){
        clazzService.removeById(id);
        return ResponseResult.ok();
    }
    

    @PostMapping
    public ResponseResult add(@RequestBody Clazz clazz){
        clazzService.save(clazz);
        return ResponseResult.ok();
    }

    @GetMapping("/{id}")
    public ResponseResult getById(@PathVariable @NotNull Long id){
        return ResponseResult.ok(clazzService.getById(id));
    }

    @PutMapping
    public ResponseResult update(@RequestBody @Validated Clazz clazz){
        clazzService.updateById(clazz);
        return ResponseResult.ok();
    }


}

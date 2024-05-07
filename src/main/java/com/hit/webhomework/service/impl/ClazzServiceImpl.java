package com.hit.webhomework.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hit.webhomework.domain.ResponseResult;
import com.hit.webhomework.domain.entity.Clazz;
import com.hit.webhomework.domain.response.PageResponse;
import com.hit.webhomework.service.ClazzService;
import com.hit.webhomework.mapper.ClazzMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* @author sardinary
* @description 针对表【clazz】的数据库操作Service实现
* @createDate 2024-05-07 10:25:39
*/
@Service
public class ClazzServiceImpl extends ServiceImpl<ClazzMapper, Clazz>
    implements ClazzService{

    @Override
    public ResponseResult getList(String name, Integer page, Integer pageSize) {
        LambdaQueryWrapper<Clazz> queryWrapper = new LambdaQueryWrapper<Clazz>()
                .like(!StrUtil.isBlankIfStr(name), Clazz::getName, name);

        Page<Clazz> page1 = new Page<>(page, pageSize);
        page(page1, queryWrapper);
        PageResponse pageResponse = new PageResponse(page1.getRecords(), page1.getTotal());
        return ResponseResult.ok(pageResponse);
    }
}





package com.hit.webhomework.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hit.webhomework.domain.ResponseResult;
import com.hit.webhomework.domain.entity.Stu;
import com.hit.webhomework.domain.response.PageResponse;
import com.hit.webhomework.service.StuService;
import com.hit.webhomework.mapper.StuMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
* @author sardinary
* @description 针对表【stu】的数据库操作Service实现
* @createDate 2024-05-06 20:07:40
*/
@Service
public class StuServiceImpl extends ServiceImpl<StuMapper, Stu>
    implements StuService{


    @Override
    public ResponseResult selectAll(String name, String id, Integer education, Integer clazz, Integer page, Integer pageSize) {
        LambdaQueryWrapper<Stu> queryWrapper = new LambdaQueryWrapper<Stu>()
                .like(!StrUtil.isBlankIfStr(name), Stu::getName, name)
                .like(!StrUtil.isBlankIfStr(id), Stu::getId, id)
                .eq(Objects.nonNull(education), Stu::getEducation, education)
                .eq(Objects.nonNull(clazz), Stu::getClazz, clazz);

        Page<Stu> page1 = new Page<>(page, pageSize);
        page(page1, queryWrapper);
        PageResponse pageResponse = new PageResponse(page1.getRecords(), page1.getTotal());
        return ResponseResult.ok(pageResponse);
    }
}





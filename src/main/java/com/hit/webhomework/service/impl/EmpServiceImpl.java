package com.hit.webhomework.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hit.webhomework.domain.ResponseResult;
import com.hit.webhomework.domain.entity.Emp;
import com.hit.webhomework.domain.request.LoginRequest;
import com.hit.webhomework.domain.response.*;
import com.hit.webhomework.enums.AppHttpCodeEnum;
import com.hit.webhomework.service.EmpService;
import com.hit.webhomework.mapper.EmpMapper;
import com.hit.webhomework.utils.JwtUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
* @author sardinary
* @description 针对表【emp(员工表)】的数据库操作Service实现
* @createDate 2024-05-03 09:48:49
*/
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp>
    implements EmpService{

    @Override
    public ResponseResult getList(String name, Integer gender, Date startTime, Date endTime, Integer page, Integer pageSize) {
        LambdaQueryWrapper<Emp> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StrUtil.isNotBlank(name), Emp::getName, name)
                .eq(Objects.nonNull(gender),Emp::getGender, gender);
        if (startTime != null) {
            queryWrapper.ge(Emp::getEntryDate, startTime);
        }
        if (endTime != null) {
            queryWrapper.le(Emp::getEntryDate, endTime);
        }
        Page<Emp> page1 = new Page<>(page, pageSize);
        page(page1, queryWrapper);
        PageResponse pageResponse = new PageResponse(page1.getRecords(), page1.getTotal());
        return ResponseResult.ok(pageResponse);
    }

    @Override
    public ResponseResult login(LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        List<Emp> list = new LambdaQueryChainWrapper<>(baseMapper).eq(Emp::getUsername, username).eq(Emp::getPassword, password).list();
        if (!list.isEmpty()) {
            Emp emp = list.get(0);
            String token = JwtUtils.getToken(emp.getId() + "");
            LoginResponse loginResponse = new LoginResponse(emp.getId(), token);
            return ResponseResult.ok(loginResponse);
        } else {
            return ResponseResult.error(AppHttpCodeEnum.LOGIN_FAILED);
        }
    }

    @Override
    public List<EmpJobAggResponse> getAggJob() {
        return baseMapper.getAggJob();
    }

    @Override
    public List<EmpDeptAggResponse> getAggDept() {
        return baseMapper.getAggDept();
    }

    @Override
    public List<EmpGenderAggResponse> getAggGender() {
        return baseMapper.getAggGender();
    }
}





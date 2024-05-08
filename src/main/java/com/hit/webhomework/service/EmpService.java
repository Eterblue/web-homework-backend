package com.hit.webhomework.service;

import com.hit.webhomework.domain.ResponseResult;
import com.hit.webhomework.domain.entity.Emp;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hit.webhomework.domain.request.LoginRequest;
import com.hit.webhomework.domain.response.EmpDeptAggResponse;
import com.hit.webhomework.domain.response.EmpGenderAggResponse;
import com.hit.webhomework.domain.response.EmpJobAggResponse;

import java.util.Date;
import java.util.List;

/**
* @author sardinary
* @description 针对表【emp(员工表)】的数据库操作Service
* @createDate 2024-05-03 09:48:49
*/
public interface EmpService extends IService<Emp> {

    ResponseResult getList(String name, Integer gender, Date startTime, Date endTime, Integer page, Integer pageSize);

    ResponseResult login(LoginRequest loginRequest);

    List<EmpJobAggResponse> getAggJob();

    List<EmpDeptAggResponse> getAggDept();

    List<EmpGenderAggResponse> getAggGender();
}

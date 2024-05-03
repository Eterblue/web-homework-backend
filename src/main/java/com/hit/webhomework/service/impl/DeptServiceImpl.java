package com.hit.webhomework.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hit.webhomework.domain.ResponseResult;
import com.hit.webhomework.domain.entity.Dept;
import com.hit.webhomework.service.DeptService;
import com.hit.webhomework.mapper.DeptMapper;
import org.springframework.stereotype.Service;

/**
* @author sardinary
* @description 针对表【dept(部门表)】的数据库操作Service实现
* @createDate 2024-05-03 09:40:39
*/
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept>
    implements DeptService{
}





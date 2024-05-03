package com.hit.webhomework.mapper;

import com.hit.webhomework.domain.entity.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author sardinary
* @description 针对表【dept(部门表)】的数据库操作Mapper
* @createDate 2024-05-03 09:40:39
* @Entity com.hit.webhomework.domain.entity.Dept
*/
@Mapper
public interface DeptMapper extends BaseMapper<Dept> {

}





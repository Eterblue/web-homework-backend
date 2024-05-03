package com.hit.webhomework.mapper;

import com.hit.webhomework.domain.entity.Emp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author sardinary
* @description 针对表【emp(员工表)】的数据库操作Mapper
* @createDate 2024-05-03 09:48:49
* @Entity com.hit.webhomework.domain.entity.Emp
*/
@Mapper
public interface EmpMapper extends BaseMapper<Emp> {

}





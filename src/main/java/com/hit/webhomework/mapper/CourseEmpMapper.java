package com.hit.webhomework.mapper;

import com.hit.webhomework.domain.entity.CourseEmp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hit.webhomework.domain.response.CourseEmpListResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author sardinary
* @description 针对表【course_emp】的数据库操作Mapper
* @createDate 2024-05-07 20:51:13
* @Entity com.hit.webhomework.domain.entity.CourseEmp
*/
@Mapper
public interface CourseEmpMapper extends BaseMapper<CourseEmp> {

}





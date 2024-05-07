package com.hit.webhomework.mapper;

import com.hit.webhomework.domain.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author sardinary
* @description 针对表【course】的数据库操作Mapper
* @createDate 2024-05-07 20:52:36
* @Entity com.hit.webhomework.domain.entity.Course
*/
@Mapper
public interface CourseMapper extends BaseMapper<Course> {

}





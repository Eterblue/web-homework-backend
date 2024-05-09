package com.hit.webhomework.mapper;

import com.hit.webhomework.domain.entity.Stu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hit.webhomework.domain.response.StuClazzAggResponse;
import com.hit.webhomework.domain.response.StuGenderAggResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author sardinary
* @description 针对表【stu】的数据库操作Mapper
* @createDate 2024-05-06 20:07:40
* @Entity com.hit.webhomework.domain.entity.Stu
*/
@Mapper
public interface StuMapper extends BaseMapper<Stu> {

    List<StuClazzAggResponse> getAggClazz();

    List<StuGenderAggResponse> getAggGender();
}





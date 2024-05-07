package com.hit.webhomework.domain.response;

import lombok.Data;

@Data
public class CourseEmpListResponse {
    private String courseId;
    private String courseName;
    private Integer empId;
    private String empName;
}

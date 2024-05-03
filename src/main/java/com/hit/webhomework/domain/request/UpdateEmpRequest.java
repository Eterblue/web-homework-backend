package com.hit.webhomework.domain.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class UpdateEmpRequest {
    @NotNull
    private Integer id;
    @NotBlank
    private String username;
    @NotBlank
    private String name;
    @NotNull
    private Integer gender;
    private String image;
    private Integer job;
    private Date entrydate;
    private Integer deptId;
}

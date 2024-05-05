package com.hit.webhomework.domain.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date entryDate;
    private Integer deptId;
}

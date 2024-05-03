package com.hit.webhomework.domain.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateDeptRequest {
    @NotNull
    private Integer id;
    @NotBlank
    private String name;
}

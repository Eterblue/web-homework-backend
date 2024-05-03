package com.hit.webhomework.domain.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddDeptRequest {
    @NotBlank
    private String name;
}

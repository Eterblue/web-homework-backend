package com.hit.webhomework.domain.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageResponse {
    private List rows;
    private Long total;
}

package com.hit.webhomework.domain.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @TableName clazz
 */
@TableName(value ="clazz")
@Data
public class Clazz implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String classroom;

    /**
     * 
     */
    private Integer headTeacher;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
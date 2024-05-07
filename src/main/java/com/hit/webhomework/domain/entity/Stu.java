package com.hit.webhomework.domain.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @TableName stu
 */
@TableName(value ="stu")
@Data
public class Stu implements Serializable {
    /**
     * 
     */
    @TableId
    private String id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Integer clazz;

    /**
     * 
     */
    private Integer gender;

    /**
     * 
     */
    private String phone;

    /**
     * 
     */
    private Integer education;

    /**
     * 
     */
    private Integer illegalTime;

    private Integer illegalGrade;

    /**
     * 
     */
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    /**
     * 
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
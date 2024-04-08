package com.sky.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 由于前端提交的数据和实体类中对应属性差别比较大，所以使用了DTO来封装员工数据
 */
@Data
public class EmployeeDTO implements Serializable {

    private Long id;

    private String username;

    private String name;

    private String phone;

    private String sex;

    private String idNumber;

}

package com.sda.employeemanager.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDto {

    private Long id;
    private String name;
    private String email;
    private String address;
    private String jobTitle;
    private String phone;
    private String imageUrl;
    private String registrationNumber;
}

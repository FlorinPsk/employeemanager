package com.sda.employeemanager.model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "employees")
@Data
public class Employee {

    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, name = "job_title")
    private String jobTitle;

    private String phone;

    private String imageUrl;

    @Column(nullable = false, updatable = false)
    private String registrationNumber;
}


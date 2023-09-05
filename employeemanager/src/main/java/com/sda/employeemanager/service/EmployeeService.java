package com.sda.employeemanager.service;

import com.sda.employeemanager.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> getAll();

    EmployeeDto getById(Long id);

    EmployeeDto findByName(String name);

    EmployeeDto findByAddress(String address);

    EmployeeDto findByEmail(String email);

    EmployeeDto findByPhone(String phone);

    EmployeeDto findByJobTitle(String jobTitle);

    EmployeeDto findByRegistrationNumber(String registrationNumber);

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

//    EmployeeDto updateEmployee(EmployeeDto employeeDto, Long id);
    EmployeeDto updateEmployee(EmployeeDto employeeDto);

    void deleteEmployeeById(Long id);
}

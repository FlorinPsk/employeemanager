package com.sda.employeemanager.dto.converter;

import com.sda.employeemanager.dto.EmployeeDto;
import com.sda.employeemanager.model.Employee;
import org.modelmapper.ModelMapper;

public class EntityDtoConverter {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Employee toEntity(EmployeeDto employeeDto) {
        return modelMapper.map(employeeDto, Employee.class);
    }

    public static EmployeeDto toDto(Employee employee) {
        return modelMapper.map(employee, EmployeeDto.class);
    }
}

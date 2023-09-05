package com.sda.employeemanager.service.implementation;

import com.sda.employeemanager.dto.EmployeeDto;
import com.sda.employeemanager.dto.converter.EntityDtoConverter;
import com.sda.employeemanager.exception.NotFoundException;
import com.sda.employeemanager.model.Employee;
import com.sda.employeemanager.repository.EmployeeRepository;
import com.sda.employeemanager.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImplementation implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDto> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(EntityDtoConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        "Employee with id " + id + "was not found."));
        return EntityDtoConverter.toDto(employee);
    }

    @Override
    public EmployeeDto findByName(String name) {
        Employee employee = employeeRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException(
                        "Employee '" + name + "' was not found."
                ));
        return EntityDtoConverter.toDto(employee);
    }

    @Override
    public EmployeeDto findByAddress(String address) {
        Employee employee = employeeRepository.findByAddress(address)
                .orElseThrow(() -> new NotFoundException(
                        "Employee with address " + address + " was not found."
                ));
        return EntityDtoConverter.toDto(employee);
    }

    @Override
    public EmployeeDto findByEmail(String email) {
        Employee employee = employeeRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException(
                        "Employee with email " + email + " was not found."
                ));
        return EntityDtoConverter.toDto(employee);
    }

    @Override
    public EmployeeDto findByPhone(String phone) {
        Employee employee = employeeRepository.findByPhone(phone)
                .orElseThrow(() -> new NotFoundException(
                        "Employee with phone number " + phone + " was not found."
                ));
        return EntityDtoConverter.toDto(employee);
    }

    @Override
    public EmployeeDto findByJobTitle(String jobTitle) {
        Employee employee = employeeRepository.findByJobTitle(jobTitle)
                .orElseThrow(() -> new NotFoundException(
                        "Employee with job " + jobTitle + " was not found."
                ));
        return EntityDtoConverter.toDto(employee);
    }

    @Override
    public EmployeeDto findByRegistrationNumber(String registrationNumber) {
        Employee employee = employeeRepository.findEmployeeByRegistrationNumber(registrationNumber)
                .orElseThrow(() -> new NotFoundException(
                        "Employee with registration number " + registrationNumber + " was not found."
                ));
        return EntityDtoConverter.toDto(employee);
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDTO) {
        employeeDTO.setRegistrationNumber(UUID.randomUUID().toString());
        Employee employee = EntityDtoConverter.toEntity(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return EntityDtoConverter.toDto(savedEmployee);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDTO) {
        Optional<Employee> existingEmployeeOptional = employeeRepository.findById(employeeDTO.getId());
        if (existingEmployeeOptional.isEmpty()) {
            throw new NotFoundException(String.format("Employee with id %s was not found!", employeeDTO.getId()));
        }
        Employee updatedEmployee = EntityDtoConverter.toEntity(employeeDTO);
        updatedEmployee = employeeRepository.save(updatedEmployee);
        return EntityDtoConverter.toDto(updatedEmployee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        "Employee with id " + id + " was not found."));
        employeeRepository.deleteById(id);
    }
}

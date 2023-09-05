package com.sda.employeemanager.controller;

import com.sda.employeemanager.dto.EmployeeDto;
import com.sda.employeemanager.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<EmployeeDto> create(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return ResponseEntity.ok(savedEmployee);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeDto>> getAll() {
        List<EmployeeDto> employees = employeeService.getAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<EmployeeDto> getById(@PathVariable("id") Long id) {
        EmployeeDto employeeDto = employeeService.getById(id);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto updatedEmployee = employeeService.updateEmployee(employeeDto);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<String>("Employee has been deleted successfully.", HttpStatus.OK);
    }
}

package com.sda.employeemanager.repository;

import com.sda.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByName(String name);

    Optional<Employee> findByAddress(String address);

    Optional<Employee> findByEmail(String email);

    Optional<Employee> findByPhone(String phone);

    Optional<Employee> findByJobTitle(String jobTitle);

    Optional<Employee> findEmployeeByRegistrationNumber(String registrationNumber);
}

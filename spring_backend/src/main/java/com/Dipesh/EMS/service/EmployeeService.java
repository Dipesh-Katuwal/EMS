package com.Dipesh.EMS.service;

import com.Dipesh.EMS.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getEmployees();
    EmployeeDto getEmpById(Long id);
    EmployeeDto updateEmployee(Long id, EmployeeDto updatedEmployee);
    void deleteEmployee(Long id);
}

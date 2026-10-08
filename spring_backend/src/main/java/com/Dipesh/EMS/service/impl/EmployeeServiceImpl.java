package com.Dipesh.EMS.service.impl;

import com.Dipesh.EMS.dto.EmployeeDto;
import com.Dipesh.EMS.entity.Employee;
import com.Dipesh.EMS.mapper.EmployeeMapper;
import com.Dipesh.EMS.repository.EmployeeRepository;
import com.Dipesh.EMS.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository repo;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapTOEmployee(employeeDto);
        Employee savedEmployee = repo.save(employee);
        return EmployeeMapper.mapTOEmployeeDto(savedEmployee);
    }
}

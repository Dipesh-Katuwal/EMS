package com.Dipesh.EMS.service.impl;

import com.Dipesh.EMS.dto.EmployeeDto;
import com.Dipesh.EMS.entity.Employee;
import com.Dipesh.EMS.exception.ResourceNotFoundException;
import com.Dipesh.EMS.mapper.EmployeeMapper;
import com.Dipesh.EMS.repository.EmployeeRepository;
import com.Dipesh.EMS.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<EmployeeDto> getEmployees() {
      List<Employee> employees = repo.findAll();
      return employees.stream().map(EmployeeMapper::mapTOEmployeeDto).toList();
    }

    @Override
    public EmployeeDto getEmpById(Long id) {
        Employee emp = repo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee not found with id "+id));
        return EmployeeMapper.mapTOEmployeeDto(emp);
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto updatedEmployee) {
        Employee emp = repo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found with id "+ id));
        emp.setFirstName(updatedEmployee.getFirstName());
        emp.setLastName(updatedEmployee.getLastName());
        emp.setEmailId(updatedEmployee.getEmail());
        repo.save(emp);
        return EmployeeMapper.mapTOEmployeeDto(emp);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee emp = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        repo.delete(emp);
    }


}

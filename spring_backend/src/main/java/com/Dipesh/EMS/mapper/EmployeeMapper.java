package com.Dipesh.EMS.mapper;

import com.Dipesh.EMS.dto.EmployeeDto;
import com.Dipesh.EMS.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapTOEmployeeDto(Employee emp){
        EmployeeDto dto= new EmployeeDto();
        dto.setId(emp.getId());
        dto.setFirstName(emp.getFirstName());
        dto.setLastName(emp.getLastName());
        dto.setEmail(emp.getEmailId());
        return dto;
    }
    public static Employee mapTOEmployee(EmployeeDto emp){
        Employee empl = new Employee();
        empl.setFirstName(emp.getFirstName());
        empl.setLastName(emp.getLastName());
        empl.setEmailId(emp.getEmail());
        return empl;
    }
}

/*
MapStruct (auto-generates mapper)

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDto toDto(Employee emp);
    Employee toEntity(EmployeeDto dto);
}
MapStruct writes the implementation for you at compile time — cleaner, less boilerplate. This need extra dependency and may conflict with lombok so don't use it for simple project.
*/
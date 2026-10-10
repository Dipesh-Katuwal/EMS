package com.Dipesh.EMS.controller;

import com.Dipesh.EMS.dto.EmployeeDto;
import com.Dipesh.EMS.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService service;
    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = service.createEmployee(employeeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }
    @GetMapping("/getEmployees")
    public ResponseEntity<List<EmployeeDto>> getEmployees(){
        List<EmployeeDto> employees = service.getEmployees();
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }
    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<EmployeeDto> getEmpById(@PathVariable Long id){
        EmployeeDto emp = service.getEmpById(id);
        return ResponseEntity.status(HttpStatus.OK).body(emp);
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id,@RequestBody EmployeeDto dto){
        EmployeeDto emp = service.updateEmployee(id,dto);
        return ResponseEntity.status(HttpStatus.OK).body(emp);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        service.deleteEmployee(id);
        return ResponseEntity.ok("Employee Deleted Successfully !");
    }
}

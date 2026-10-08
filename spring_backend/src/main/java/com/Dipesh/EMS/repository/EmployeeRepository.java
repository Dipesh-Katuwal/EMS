package com.Dipesh.EMS.repository;

import com.Dipesh.EMS.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

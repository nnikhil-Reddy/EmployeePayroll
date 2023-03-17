package com.realpage.Payroll.repository;

import com.realpage.Payroll.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}

package com.realpage.Payroll.service;
import com.realpage.Payroll.model.*;
import com.realpage.Payroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> listAllEmployee(){
        return employeeRepository.findAll();
    }
    public void saveEmployee(Employee employee)
    {
        employeeRepository.save(employee);
    }
    public Employee getEmployee(Long id)
    {
        return employeeRepository.findById(id).get();
    }
    public void deleteEmployee(Long id)
    {
        employeeRepository.deleteById(id);
    }

}

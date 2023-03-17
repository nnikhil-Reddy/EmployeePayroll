package com.realpage.Payroll;

import com.realpage.Payroll.model.*;
import com.realpage.Payroll.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/employee")
public class Controller {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("")
    public List<Employee> list()
    {
        return employeeService.listAllEmployee();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> get(@PathVariable Long id)
    {
        try{
            Employee employee= employeeService.getEmployee(id);
            return new ResponseEntity<Employee>(employee,HttpStatus.OK);
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Employee employee)
    {
        employeeService.saveEmployee(employee);
    }
    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody Employee employee, @PathVariable Long id)
    {
     try {
         Employee existEmployee = employeeService.getEmployee(id);
         employee.setId(id);
         employeeService.saveEmployee(employee);
         return new ResponseEntity<>(HttpStatus.OK);
     }
     catch (NoSuchElementException e){
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id)
    {
        employeeService.deleteEmployee(id);
    }
}

package com.realpage.Payroll.model;

import java.util.Objects;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Table(name="employee")
public class Employee {

    private  Long id;
    private String firstName;
    private String lastName;

    Employee() {}

    Employee(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + ", FirstName='" + this.firstName + '\'' + ", LastName='" + this.lastName + '\'' + '}';
    }
}
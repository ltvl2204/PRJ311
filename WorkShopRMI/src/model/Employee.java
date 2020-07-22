/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Viet Long
 */
public class Employee implements Serializable{

    private String emp_id;
    private String lastName;
    private String firstName;
    private char gender;
    private String email;

    public Employee() {
    }

    public Employee(String emp_id, String lastName, String firstName, char gender, String email) {
        this.emp_id = emp_id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.email = email;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" + "emp_id=" + emp_id + ", lastName=" + lastName + ", firstName=" + firstName + ", gender=" + gender + ", email=" + email + '}';
    }

    
    
}

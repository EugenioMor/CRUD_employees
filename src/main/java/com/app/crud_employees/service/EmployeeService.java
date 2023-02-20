package com.app.crud_employees.service;

import java.util.List;
import com.app.crud_employees.entity.Employee;

public interface EmployeeService {

    public List<Employee> listAllEmployees();

    public Employee saveEmployee(Employee employee);

    public Employee getEmployeeById(Long id);

    public Employee updateEmployee(Employee employee);

    public void deleteEmployee(Long id);
}

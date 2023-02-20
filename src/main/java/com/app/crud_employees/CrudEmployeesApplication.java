package com.app.crud_employees;

import com.app.crud_employees.entity.Employee;
import com.app.crud_employees.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudEmployeesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrudEmployeesApplication.class, args);
	}

	@Autowired
	private EmployeeRepository repository;

	@Override
	public void run(String... args) throws Exception {
		/*
		Employee employee1 = new Employee("Eugenio", "Morales", "morales@gmail.com");
		repository.save(employee1);

		Employee employee2 = new Employee("Karina", "Gómez", "karina@gmail.com");
		repository.save(employee2);
		*/
	}
}

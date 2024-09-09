package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Employee;
import com.demo.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public Employee addEmployee(Employee employee) {
		Employee emp = employeeRepo.save(employee);
		return emp;
	}

	@Override
	public String removeEmployee(int id) {
		employeeRepo.deleteById(id);
		return "Delete data successfully";
	}

	@Override
	public Optional<Employee> findEmpById(int id) {
		Optional<Employee> emp = employeeRepo.findById(id);
		if (emp.isPresent()) {
			return emp;
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> empList = employeeRepo.findAll();
		return empList;
	}

	@Override
	public String updateEmployee(int id) {
		Optional<Employee> emp = employeeRepo.findById(id);
		if (emp.isPresent()) {
			Employee emps = new Employee();
			employeeRepo.save(emps);
			return "Updated successfully";
		} else {
			return "Employee not found";

		}

	}
}
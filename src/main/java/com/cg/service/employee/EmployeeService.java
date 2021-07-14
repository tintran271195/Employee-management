package com.cg.service.employee;

import com.cg.model.Employee;
import com.cg.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService{

	@Autowired
	private IEmployeeRepository employeeRepository;

	@Override
	public Iterable<Employee> findAll () {
		return employeeRepository.findAll ();
	}

	@Override
	public Optional<Employee> findById (Long id) {
		return employeeRepository.findById (id);
	}

	@Override
	public Employee save (Employee employee) {
		return employeeRepository.save (employee);
	}

	@Override
	public void remove (Long id) {
	  employeeRepository.deleteById (id);
	}




}

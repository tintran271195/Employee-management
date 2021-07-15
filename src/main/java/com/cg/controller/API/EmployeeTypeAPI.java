package com.cg.controller.API;

import com.cg.model.EmployeeType;
import com.cg.service.employeeType.IEmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api/employee-types")
public class EmployeeTypeAPI {
	@Autowired
	private IEmployeeTypeService employeeTypeService;

	@GetMapping
	public ResponseEntity<Iterable<EmployeeType>> allEmployeeTypes() {
		Iterable<EmployeeType> employeeTypes = employeeTypeService.findAll();
		if (((List) employeeTypes).isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(employeeTypes, HttpStatus.OK);
	}
}

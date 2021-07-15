package com.cg.controller.API;

import com.cg.model.Department;

import com.cg.service.department.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping ("/api/departments")
public class DepartmentAPI {

	@Autowired
	private IDepartmentService departmentService;


	@GetMapping
	public ResponseEntity<Iterable<Department>> getDepartments () {

		Iterable<Department> departments = departmentService.findAll ();
		if (((List) departments).isEmpty ()) {
			return new ResponseEntity<> (HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<> (departments, HttpStatus.OK);
	}

	@GetMapping ("/{typeId}")
	public ResponseEntity<Iterable<Department>> getDepartments (@PathVariable Long typeId) {

		Iterable<Department> departments = departmentService.findAllByEmployeeType_Id (typeId);
		if (((List) departments).isEmpty ()) {
			return new ResponseEntity<> (HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<> (departments, HttpStatus.OK);
	}

}

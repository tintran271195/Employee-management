package com.cg.controller.API;

import com.cg.model.Department;
import com.cg.model.EmployeeType;
import com.cg.model.Position;
import com.cg.service.department.IDepartmentService;
import com.cg.service.position.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api/positions")
public class PositionAPI {
	@Autowired
	private IPositionService positionService;

	@GetMapping
	public ResponseEntity<Iterable<Position>> allPosition() {
		Iterable<Position> positions = positionService.findAll();
		if (((List) positions).isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(positions, HttpStatus.OK);
	}


	@GetMapping ("/{departmentId}")
	public ResponseEntity<Iterable<Position>> getAllPositionByDepartment(@PathVariable Long departmentId) {

		Iterable<Position> positions = positionService.findAllByDepartment (departmentId);
		if (((List) positions).isEmpty ()) {
			return new ResponseEntity<> (HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<> (positions, HttpStatus.OK);
	}
}

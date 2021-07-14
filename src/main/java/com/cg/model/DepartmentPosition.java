package com.cg.model;

import javax.persistence.*;

@Entity
public class DepartmentPosition {
	@Id
	private Long id;

	@ManyToOne
	@MapsId("id")
	@JoinColumn (name = "positionId")
	private Position position;

	@ManyToOne
	@MapsId ("id")
	@JoinColumn(name = "departmentId")
	private Department department;



}

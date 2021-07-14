package com.cg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "departments")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable=false)
	private String departmentName;

	@ManyToOne
	@JoinColumn(name = "employeeTypeId")
	private EmployeeType employeeType;


	@OneToMany(mappedBy = "department")
	private Set<DepartmentPosition> departmentPosition;
	
	
	public Department (String departmentName) {
		this.departmentName = departmentName;
	}

	public Department (String departmentName, EmployeeType employeeType) {
		this.departmentName = departmentName;
		this.employeeType = employeeType;

	}

}

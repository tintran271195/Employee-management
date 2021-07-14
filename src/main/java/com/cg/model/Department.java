package com.cg.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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


	@OneToMany(targetEntity = Position.class, fetch = FetchType.EAGER)
	private Set<Position> positions;
	
	public Department (String departmentName) {
		this.departmentName = departmentName;
	}

}

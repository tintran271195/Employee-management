package com.cg.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;


	@Column
	private String avatar;

	@Column(nullable=false)
	private String fullName;

	@Column(nullable=false)
	private String dob;

	@Column(nullable=false)
	private String gender;

	@Column(nullable=false)
	private String email;

	@Column(nullable=false)
	private String phone;

	@Column(nullable=false)
	private String address;

	private String workResume;


	@ManyToOne
	@JoinColumn(name="employeeTypeId")
	private EmployeeType employeeType;

	@OneToOne
	@JoinColumn(name="departmentId")
	private Department department;

	@OneToOne
	@JoinColumn(name="positionId")
	private Position position;

	public Employee (String avatar, String fullName, String dob, String gender, String email, String phone, String address, String workResume) {
		this.fullName = fullName;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.workResume = workResume;
		this.avatar = avatar;
	}

	public Employee (String avatar, String fullName, String dob, String gender, String email, String phone, String address, String workResume, EmployeeType employeeType, Department department, Position position) {
		this.avatar = avatar;
		this.fullName = fullName;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.workResume = workResume;
		this.employeeType = employeeType;
		this.department = department;
		this.position = position;
	}

}
package com.cg.model;

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


	@Column(nullable=false)
	private String avatar;

	@Column(nullable=false)
	private String fullName;

	@Column(nullable=false)
	private Date dob;

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
	@JoinColumn(name="positionId")
	private Position position;

	@ManyToOne
	@JoinColumn(name="employeeTypeId")
	private EmployeeType employeeType;

	public Employee (String avatar, String fullName, Date dob, String gender, String email, String phone, String address, String workResume) {
		this.fullName = fullName;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.workResume = workResume;
		this.avatar = avatar;
	}

	public Employee (String fullName, Date dob, String gender, String email, String phone, String address, String workResume, String avatar, EmployeeType employeeType, Position position) {
		this.fullName = fullName;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.workResume = workResume;
		this.avatar = avatar;
		this.employeeType = employeeType;
		this.position = position;
	}

}
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
@Table (name = "positions")
public class Position {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable=false)
	private String positionName;

	@ManyToOne
	@JoinColumn(name = "departmentId")
	private Department department;

	public Position (String positionName) {
		this.positionName = positionName;
	}

}

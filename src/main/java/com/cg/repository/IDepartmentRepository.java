package com.cg.repository;

import com.cg.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDepartmentRepository extends JpaRepository<Department, Long> {
	Iterable<Department> findAllByEmployeeType_Id(Long id);
}

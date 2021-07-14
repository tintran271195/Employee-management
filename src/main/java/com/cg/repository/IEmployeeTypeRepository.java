package com.cg.repository;


import com.cg.model.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeTypeRepository extends JpaRepository<EmployeeType, Long> {

}

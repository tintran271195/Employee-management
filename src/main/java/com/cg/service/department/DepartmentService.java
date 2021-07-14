package com.cg.service.department;

import com.cg.model.Department;
import com.cg.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements IDepartmentService{

	@Autowired
	private IDepartmentRepository departmentRepository;

	@Override
	public Iterable<Department> findAll () {
		return departmentRepository.findAll ();
	}

	@Override
	public Optional<Department> findById (Long id) {
		return departmentRepository.findById (id);
	}

	@Override
	public Department save (Department department) {
		return departmentRepository.save (department);
	}

	@Override
	public void remove (Long id) {
		departmentRepository.deleteById (id);
	}


	@Override
	public Iterable<Department> findAllByEmployeeType_Id (long id) {
		return departmentRepository.findAllByEmployeeType_Id (id);
	}

}

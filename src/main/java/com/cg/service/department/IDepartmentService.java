package com.cg.service.department;

import com.cg.model.Department;
import com.cg.service.IGeneralService;

import java.util.List;

public interface IDepartmentService extends IGeneralService<Department> {
	Iterable<Department> findAllByEmployeeType_Id(Long id);

}

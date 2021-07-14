package com.cg.service.employee;

import com.cg.model.Employee;
import com.cg.service.IGeneralService;

public interface IEmployeeService extends IGeneralService<Employee> {

//	@Query("SELECT e,et.typeName,d.departmentName,p.positionName FROM Employee e, EmployeeType  et, Department d, Position p")
//	Iterable<Employee> findAllEmployees();

}

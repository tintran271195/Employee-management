package com.cg.controller.API;

import com.cg.model.Department;
import com.cg.model.Employee;
import com.cg.model.EmployeeType;
import com.cg.model.Position;
import com.cg.service.department.IDepartmentService;
import com.cg.service.employee.EmployeeService;
import com.cg.service.employee.IEmployeeService;
import com.cg.service.employeeType.IEmployeeTypeService;
import com.cg.service.position.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeAPI {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IEmployeeTypeService employeeTypeService;

    @Autowired
    private IDepartmentService departmentService;

    @Autowired
    private IPositionService positionService;

    @GetMapping
    public ResponseEntity<Iterable<Employee>> getAllEmployees() {
        Iterable<Employee> employees = employeeService.findAll();
        if (((List) employees).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);

    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Employee> getId(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        if (employee.getId() != null) {
            return new ResponseEntity<>(employeeService.save(employee), HttpStatus.OK);
        }

        Optional<EmployeeType> employeeType = employeeTypeService.findById(employee.getEmployeeType().getId());
        Optional<Department> department = departmentService.findById(employee.getDepartment().getId());
        Optional<Position> position = positionService.findById(employee.getPosition().getId());

        if (employeeType.isPresent()) {
            employee.setEmployeeType(employeeType.get());
            return new ResponseEntity<>(employeeService.save(employee), HttpStatus.CREATED);
        }
        if (department.isPresent()) {
            employee.setDepartment(department.get());
            return new ResponseEntity<>(employeeService.save(employee), HttpStatus.OK);
        }
        if (position.isPresent()) {
            employee.setPosition(position.get());
            return new ResponseEntity<>(employeeService.save(employee), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping()
    public ResponseEntity<Employee> deleteEmployee(@RequestBody Map<String, String> json) {
        Long id = Long.valueOf(json.get("id"));
        Optional<Employee> employeeOptional = employeeService.findById(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeeService.remove(id);
        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.NO_CONTENT);
    }

}

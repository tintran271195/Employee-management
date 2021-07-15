package com.cg.controller.API;

import com.cg.model.Employee;
import com.cg.model.EmployeeType;
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
@RequestMapping ("/api/employees")
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
	public ResponseEntity<Iterable<Employee>> getAllEmployees () {
		Iterable<Employee> employees = employeeService.findAll ();
		if (((List) employees).isEmpty ()) {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<> (employees, HttpStatus.OK);

	}
	@GetMapping ("/view/{id}")
	public ResponseEntity<Employee> getId (@PathVariable Long id) {
		Optional<Employee> employee = employeeService.findById (id);
		if (employee.isPresent ()) {
			return new ResponseEntity<> (employee.get (), HttpStatus.OK);
		} else {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
	}


//	@PostMapping("/edit")
//	public String updateProduct(@ModelAttribute("product") Product product, HttpServletRequest request, @ModelAttribute("uploadFile") UploadFile uploadFile) {
//		String uploadRootPath = request.getServletContext().getRealPath("/upload/product-img/");
//		if (folderUpload.isEmpty()) {
//			folderUpload = uploadRootPath;
//		}
//		File uploadRootDir = new File(uploadRootPath);
//		if (!uploadRootDir.exists()) {
//			uploadRootDir.mkdirs();
//		}
//
//		CommonsMultipartFile[] filesData = uploadFile.getFilesData();
//		for (CommonsMultipartFile fileData : filesData) {
//
//			String fileName = fileData.getOriginalFilename();
//
//			if (fileName != null && fileName.length() > 0) {
//				try {
//					File serverFile = new File(folderUpload + fileName);
//					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream (serverFile));
//					stream.write(fileData.getBytes());
//					stream.close();
//
//					product.setImage(fileName);
//					productService.save(product);
//					System.out.println(product.getId()+product.getProductName());
//				} catch (Exception e) {
//					System.out.println("Error Write file: " + fileName);
//				}
//			}else{
//				productService.save(product);
//			}
//		}
//		return "redirect:product";
//	}

	@PostMapping
	public ResponseEntity<Employee> saveEmployee (@RequestBody Employee employee) {
		if (employee.getId () != null) {
			return new ResponseEntity<> (employeeService.save (employee), HttpStatus.OK);
		}

		Optional<EmployeeType> employeeType = employeeTypeService.findById (employee.getEmployeeType ().getId ());

		if (employeeType.isPresent ()) {
			employee.setEmployeeType (employeeType.get ());
			return new ResponseEntity<> (employeeService.save (employee), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping ()
	public ResponseEntity<Employee> deleteEmployee (@RequestBody Map<String, String> json) {
		Long id = Long.valueOf (json.get ("id"));
		Optional<Employee> employeeOptional = employeeService.findById (id);
		if (! employeeOptional.isPresent ()) {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
		employeeService.remove (id);
		return new ResponseEntity<> (employeeOptional.get (), HttpStatus.NO_CONTENT);
	}

}

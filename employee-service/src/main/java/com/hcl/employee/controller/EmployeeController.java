/**
 * 
 */
package com.hcl.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.employee.request.Employee;
import com.hcl.employee.service.EmployeeService;
import com.hcl.employee.validaion.Validation;

import io.swagger.annotations.Api;

/**
 * @author SANTOSH
 *
 */
@RestController
@Api(value = "Employee Service", description = "employee service ")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@PostMapping("/api/employee/add")
	public Object addEmployee(@RequestBody Employee employee) {
		Validation.validate(employee);
		return new ResponseEntity<>(service.save(employee), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/api/employee/", method = RequestMethod.GET)
	public Object viewEmployees() {
		Iterable<Employee> em = service.getAllEmployee();
		if (null != em) {
			return new ResponseEntity<>(em, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/api/employee/{type}", method = RequestMethod.GET)
	public Object viewEmployeeByName(@PathVariable String type) {
		return new ResponseEntity<>(service.searchByName(type), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/api/employee/edit", method = RequestMethod.PATCH)
	public Object updateEmployee(@RequestBody Employee employee) {
		service.update(employee);
		return new ResponseEntity<>("Employee edited successfully", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/api/employee/delete/{id}", method = RequestMethod.DELETE)
	public Object delete(@PathVariable Long id) {
		service.deleteProduct(id);
		return new ResponseEntity<>("Employee deleted successfully", HttpStatus.CREATED);

	}
}

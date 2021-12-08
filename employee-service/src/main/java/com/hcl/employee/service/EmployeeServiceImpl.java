/**
 * 
 */
package com.hcl.employee.service;

import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.employee.repository.EmployeeRepository;
import com.hcl.employee.request.Employee;
import com.hcl.web.exception.ApplicationException;

/**
 * @author SANTOSH
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository respository;

	@Override
	public Employee findById(long id) {
		return respository.findById(id).get();
	}

	@Override
	public Employee save(Employee employee) {
		return respository.save(employee);
	}

	@Override
	public Iterable<Employee> getAllEmployee() {
		return respository.findAll();
	}

	@Override
	public Employee findByCode(Integer code) {
		return respository.findByCode(code);
	}

	@Override
	public void update(Employee employee) {
		if (respository.existsById(employee.getId())) {
			respository.save(employee);
		}
	}

	@Override
	public void deleteProduct(Long id) {
		respository.deleteById(id);
	}

	@Override
	public Employee searchByName(String name) {
		if (Pattern.matches("[0-9]+[\\\\.]?[0-9]*", name)) {
			return respository.findByCode(Integer.parseInt(name));
		}
		if(null==name && null==respository.findByName(name)) {
			throw new ApplicationException("Record not available for this user"+name);
		}
		return respository.findByName(name);
	}
}

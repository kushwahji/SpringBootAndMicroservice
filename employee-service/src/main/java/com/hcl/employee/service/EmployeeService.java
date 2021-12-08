/**
 * 
 */
package com.hcl.employee.service;


import com.hcl.employee.request.Employee;

/**
 * @author SANTOSH
 *
 */

public interface EmployeeService {

	public Employee findById(long id);

	public Employee save(Employee employee);

	public Iterable<Employee> getAllEmployee();

	public Employee findByCode(Integer id);

	public void update(Employee employee);

	public void deleteProduct(Long id);

	public Employee searchByName(String name);
}

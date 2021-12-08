/**
 * 
 */
package com.hcl.employee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.employee.request.Employee;

/**
 * @author SANTOSH
 *
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>  {

	Employee findByCode(Integer id);

	Employee findByName(String name);

}

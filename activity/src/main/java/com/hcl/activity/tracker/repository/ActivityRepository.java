/**
 * 
 */
package com.hcl.activity.tracker.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.hcl.activity.tracker.entity.ActivityTracker;


/**
 * @author SANTOSH
 *
 */
@Repository
public interface ActivityRepository  extends CrudRepository<ActivityTracker, Long> {

	List<ActivityTracker> findByEmpName(String emp_name);

	List<ActivityTracker> findByDate(String fromDate);

	List<ActivityTracker> findByDateBetween(String fromDate, String toDate);

	List<ActivityTracker> findByEmpCode(int empCode);

	List<ActivityTracker> findByEmpCodeAndDateBetween(int emp_code, String fromDate, String toDate);

}

/**
 * 
 */
package com.hcl.activity.tracker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.hcl.activity.tracker.entity.ActivityTracker;
import com.hcl.activity.tracker.feignClient.FeignClientEmployee;
import com.hcl.activity.tracker.repository.ActivityRepository;
import com.hcl.activity.tracker.request.ActivityDateRequest;
import com.hcl.activity.tracker.request.ActivityRequest;
import com.hcl.activity.tracker.response.ActivityResponse;
import com.hcl.activity.tracker.response.Employee;
import com.hcl.web.exception.ApplicationException;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

/**
 * @author SANTOSH
 *
 */
@Service
public class ActivityServiceImpl implements ActivityService {
	@Autowired
	ActivityRepository repository;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	FeignClientEmployee foregnClientEmployee;

	@Override
	public void save(List<ActivityRequest> request) throws ApplicationException {
		try {
			List<ActivityTracker> d =  new ArrayList<>();
			LOGGER.info("inside save activity");
			request.forEach(o -> {
				List<ActivityTracker> at = repository.findByEmpCode(o.getEmpCode());
				at.forEach(a->{if(a.getEmpCode()==o.getEmpCode()) {
					throw new ApplicationException("Record already exits");
				}});
				
				if (null != getEmp(o.getEmpCode())) {
					d.add(new ActivityTracker(o));
					repository.saveAll(d);
				} else {
					throw new ApplicationException("Employee not available please add employee");
				}
			});
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		}
	}

	@Override
	public void update(ActivityRequest request) throws ApplicationException {
		List<ActivityTracker> at = repository.findByEmpCode(request.getEmpCode());
		try {
			LOGGER.info("inside save activity");
		if (null == at) {
			throw new ApplicationException("Activity not found for this employee code :: " + request.getEmpCode());
		}
		at.forEach(o -> {
			if (repository.existsById(o.getId())) {
				repository.save(new ActivityTracker(o, request));
			}
		});
	} catch (Exception e) {
		throw new ApplicationException(e.getMessage());
	}
	}

	@Override
	public void deleteProduct(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<ActivityResponse> findByName(String name) {
		return preparedResponse(repository.findByEmpName(name));
	}

	@Override
	public List<ActivityResponse> findByDate(String date) {
		return preparedResponse(repository.findByDate(date));
	}

	@Override
	public List<ActivityResponse> findDateRange(ActivityDateRequest request) {
		try {
			if (request.getEmp_code()> 0) {
				return preparedResponse(repository.findByEmpCodeAndDateBetween(request.getEmp_code(),
						request.getFromDate(), request.getToDate()));
			} else {
				return preparedResponse(repository.findByDateBetween(request.getFromDate(), request.getToDate()));
			}
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		}
	}

	private List<ActivityResponse> preparedResponse(List<ActivityTracker> activitiesList) {
		List<ActivityResponse> atLst = new ArrayList<>();
		if(activitiesList.size()>0){
			atLst = activitiesList.stream().filter(f -> f.getEmpCode() == getEmp(f.getEmpCode()).getCode())
					.map(m -> new ActivityResponse(m, getEmp(m.getEmpCode()))).collect(Collectors.toList());
		}
		return atLst;
		
	}
	
	private Employee getEmp(Integer code) throws ApplicationException {
		Employee emp = new Employee();
		try {
			emp = foregnClientEmployee.findByName("" + code);
			if (null == emp) {
				throw new ApplicationException(
						"Employee not active add employee using this link : http://localhost:2011/swagger-ui.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("Employee Service is down "+e.getMessage());
		}
		return emp;
	}

}

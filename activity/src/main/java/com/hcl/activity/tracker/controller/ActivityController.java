/**
 * 
 */
package com.hcl.activity.tracker.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.activity.tracker.request.ActivityDateRequest;
import com.hcl.activity.tracker.request.ActivityRequest;
import com.hcl.activity.tracker.response.ActivityResponse;
import com.hcl.activity.tracker.service.ActivityService;
import com.hcl.activity.tracker.validation.Validation;
import com.hcl.web.exception.ApplicationException;

import io.swagger.annotations.Api;

/**
 * @author SANTOSH
 *
 */
@RestController
@Api(value = "Activity Tracker", description = "Operations pertaining to activity in activity tracker")
public class ActivityController {
	@Autowired
	ActivityService service;

	@PostMapping("/api/dailyactivity/add")
	public ResponseEntity<String> addDailyActivity(@RequestBody List<ActivityRequest> request) {
		request.forEach(v -> Validation.validate(v));
		try {
			request.forEach(o->Validation.validate(o));
			service.save(request);
			return new ResponseEntity<>("Activity created successfully", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/api/dailyactivity/name/{name}", method = RequestMethod.GET)
	public ResponseEntity<Object> viewDailyActivityWithName(@PathVariable String name) {
		List<ActivityResponse> response = new ArrayList<>();
		response = service.findByName(name);
		if (response.size() == 0) {
			return new ResponseEntity<>("Record not found for "+name,HttpStatus.NOT_FOUND); 
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/dailyactivity/{date}" , method = RequestMethod.GET)
	public ResponseEntity<Object> viewDailyActivityWithDate(@PathVariable String date) {
		List<ActivityResponse> response = new ArrayList<>();
		response = service.findByDate(date);
		if (response.size() == 0) {
			return new ResponseEntity<>("Record not found for "+date,HttpStatus.NOT_FOUND); 
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/api/dailyactivity/")
	public ResponseEntity<Object> viewDailyActivitieswithNameAndDateRange(
			@Valid @RequestBody ActivityDateRequest request) {
		Validation.validateDate(request);
		List<ActivityResponse> response = new ArrayList<>();
		response = service.findDateRange(request);
		if (response.size() == 0) {
			return new ResponseEntity<>("Record not found",HttpStatus.NOT_FOUND); 
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/dailyactivity/edit", method = RequestMethod.PATCH)
	public ResponseEntity<String> editDailyActivity(@RequestBody ActivityRequest request) {
		Validation.validate(request);
		try {
			service.update(request);
			return new ResponseEntity<>("activity edited successfully", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}

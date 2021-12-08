/**
 * 
 */
package com.hcl.activity.tracker.service;

import java.util.List;

import com.hcl.activity.tracker.request.ActivityDateRequest;
import com.hcl.activity.tracker.request.ActivityRequest;
import com.hcl.activity.tracker.response.ActivityResponse;

/**
 * @author SANTOSH
 *
 */
public interface ActivityService{
	public void save(List<ActivityRequest> employee);

	public void update(ActivityRequest request);

	public void deleteProduct(Long id);

	public List<ActivityResponse> findByDate(String date);
	
	public List<ActivityResponse> findByName(String name);

	public List<ActivityResponse> findDateRange(ActivityDateRequest request);
}

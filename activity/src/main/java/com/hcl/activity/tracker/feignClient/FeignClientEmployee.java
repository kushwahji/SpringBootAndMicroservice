package com.hcl.activity.tracker.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hcl.activity.tracker.response.Employee;

@FeignClient(name="employee-service", url= "http://localhost:2011")
public interface FeignClientEmployee {
   
    @RequestMapping("/api/employee/{type}")
    public Employee findByName(@PathVariable(value="type") String name);
}

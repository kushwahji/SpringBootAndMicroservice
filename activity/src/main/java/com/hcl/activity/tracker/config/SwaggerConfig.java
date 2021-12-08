/**
 * 
 */
package com.hcl.activity.tracker.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hcl.web.config.MsBaseConfig;

import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author SANTOSH
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Value("${com.hcl.activity.tracker.groupName}")
	public String groupName;

	@Value("${com.hcl.activity.tracker.title}")
	String title;

	@Value("${com.hcl.activity.tracker.desc}")
	String desc;

	@Value("${com.hcl.activity.tracker.version}")
	String version;

	
	
	@Bean
	public Docket configApi() {
		return MsBaseConfig.configApi(groupName, title, desc, version);
	}

	
}

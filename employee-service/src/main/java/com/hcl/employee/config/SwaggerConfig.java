/**
 * 
 */
package com.hcl.employee.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hcl.web.config.MsBaseConfig;

//import com.hcl.web.config.MsBaseConfig;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author SANTOSH
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Value("${com.hcl.employee.service.groupName}")
	public String groupName;

	@Value("${com.hcl.employee.service.title}")
	String title;
	
	@Value("${com.hcl.employee.service.desc}")
	String desc;

	@Value("${com.hcl.employee.service.version}")
	String version;


	@Bean
	public Docket configApi() {
		return MsBaseConfig.configApi(groupName, title, desc, version);
	}
	
}

/**
 * 
 */
package com.hcl.web.config;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import static springfox.documentation.builders.PathSelectors.regex;


/**
 * @author SANTOSH
 *
 */
public class MsBaseConfig  {
	

	public static Docket configApi(String groupName,String title,String desc,String version) {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo(title,desc,version)).pathMapping("/").select()
					.paths(regex("/api/.*")).build();
	}

	/**
	 * Method to set swagger info
	 *
	 * @return ApiInfoBuilder
	 */
	private static ApiInfo apiInfo(String title,String desc,String version) {
		return new ApiInfoBuilder().title(title).description(desc).version(version).build();
	}
	
}

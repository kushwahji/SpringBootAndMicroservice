/**
 * 
 */
package com.hcl.web.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

/**
 * @author SANTOSH
 *
 */
public class HttpLoggingInterceptor implements ClientHttpRequestInterceptor {
	Logger logger = LoggerFactory.getLogger(HttpLoggingInterceptor.class);

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		long startTime = System.nanoTime();
		traceRequest(request, body, startTime);
		ClientHttpResponse response = execution.execute(request, body);
		traceResponse(response, startTime);
		return null;
	}

	private String getHeaderAsString(HttpHeaders hh) {
		return hh.keySet().stream().map(k -> k + "+" + hh.getValuesAsList(k)).collect(Collectors.toList()).toString();
	}

	private void traceResponse(ClientHttpResponse response, long startTime) throws IOException {
		String responseLog = Arrays
				.asList("", "=======================Third Part Service Response Start=======================",
						"Start Time		:" + startTime, "Status Code	:" + response.getStatusCode(),
						"Status Text	:" + response.getStatusText(),
						"Headers		:" + getHeaderAsString(response.getHeaders()), "Response Body	:",
						StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()),
						"Time taken		:" + (System.nanoTime() - startTime) / 1000000 + "ms",
						"======================Third Party Service Response End=========================")
				.stream().collect(Collectors.joining(System.lineSeparator()));
		logger.info(responseLog);
	}

	private void traceRequest(HttpRequest request, byte[] body, long startTime) {
		String requestLog = Arrays
				.asList("", "=======================Third Part Service Request Start=======================",
						"Start Time		:" + startTime, "Method Name	:" + request.getMethod(),
						"URI			:" + request.getURI(),
						"Headers		:" + getHeaderAsString(request.getHeaders()),
						"Request Body	:" + new String(body),
						"======================Third Party Service Request End=========================")
				.stream().collect(Collectors.joining(System.lineSeparator()));
		logger.info(requestLog);
	}

}

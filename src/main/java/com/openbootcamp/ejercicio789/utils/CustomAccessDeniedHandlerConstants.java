package com.openbootcamp.ejercicio789.utils;

import org.springframework.http.HttpStatus;

public class CustomAccessDeniedHandlerConstants {
	public static final String APPLICATION_JSON = "application/json";
	public static final String TIMESTAMP = "timestamp";
	public static final String HTTP_STATUS_CODE = "http-status-code";
	public static final String ALIAS = "alias";
	public static final String ALIAS_VALUE = "accessDenied";
	public static final int HTTP_STATUS_CODE_VALUE = HttpStatus.FORBIDDEN.value();
	public static final String DATE_FORMAT = "dd/MM/yy HH:mm:ss,SSS";
	public static final String MESSAGE = "message";
	public static final String MESSAGE_VALUE = "Wrong information submitted";
}

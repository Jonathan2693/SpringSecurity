package com.openbootcamp.ejercicio789.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openbootcamp.ejercicio789.utils.CustomAccessDeniedHandlerConstants;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
	
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
    	ObjectMapper mapper = new ObjectMapper();
        response.setStatus(CustomAccessDeniedHandlerConstants.HTTP_STATUS_CODE_VALUE);
        response.setContentType(CustomAccessDeniedHandlerConstants.APPLICATION_JSON);
        OutputStream out = response.getOutputStream();
        mapper.writeValue(out, getBodyResponse());
        out.flush();
    }

	private Map<String, Object> getBodyResponse() {
		Map<String, Object> bodyResponse = new HashMap<>();
        bodyResponse.put(CustomAccessDeniedHandlerConstants.TIMESTAMP, getDate());
        bodyResponse.put(CustomAccessDeniedHandlerConstants.ALIAS, CustomAccessDeniedHandlerConstants.ALIAS_VALUE);
        bodyResponse.put(CustomAccessDeniedHandlerConstants.HTTP_STATUS_CODE, CustomAccessDeniedHandlerConstants.HTTP_STATUS_CODE_VALUE);
        bodyResponse.put(CustomAccessDeniedHandlerConstants.MESSAGE, CustomAccessDeniedHandlerConstants.MESSAGE_VALUE);
		return bodyResponse;
	}

	private String getDate() {
		return new SimpleDateFormat(CustomAccessDeniedHandlerConstants.DATE_FORMAT).format(new Date());
	}

}
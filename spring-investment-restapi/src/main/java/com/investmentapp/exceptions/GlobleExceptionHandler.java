package com.investmentapp.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.investmentapp.model.ApiErrors;

@ControllerAdvice
public class GlobleExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		headers.add("error", "Method not allowed");
		List<String> errormsg = new ArrayList<>();
		errormsg.add(ex.getMessage());
		errormsg.add(request.toString());
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), ex.getMessage(), status.value(), errormsg);

		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		headers.add("error", "Media type not allowed");
		List<String> errormsg  = new ArrayList<>();
		errormsg.add(ex.getMessage());
		errormsg.add(request.toString());
		ApiErrors errors  = new ApiErrors(LocalDateTime.now(),ex.getMessage(),status.value(),errormsg);
		
		
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		headers.add("error", "Missing Path Variable type not allowed");
		List<String> errormsg  = new ArrayList<>();
		errormsg.add(ex.getMessage());
		errormsg.add(request.toString());
		ApiErrors errors  = new ApiErrors(LocalDateTime.now(),ex.getMessage(),status.value(),errormsg);
		
		
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		headers.add("error", "Missing Servlet type not allowed");
		List<String> errormsg  = new ArrayList<>();
		errormsg.add(ex.getMessage());
		errormsg.add(request.toString());
		ApiErrors errors  = new ApiErrors(LocalDateTime.now(),ex.getMessage(),status.value(),errormsg);
		
		
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		headers.add("error", "Type Mismatch type not allowed");
		List<String> errormsg  = new ArrayList<>();
		errormsg.add(ex.getMessage());
		errormsg.add(request.toString());
		ApiErrors errors  = new ApiErrors(LocalDateTime.now(),ex.getMessage(),status.value(),errormsg);
		
		
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

}

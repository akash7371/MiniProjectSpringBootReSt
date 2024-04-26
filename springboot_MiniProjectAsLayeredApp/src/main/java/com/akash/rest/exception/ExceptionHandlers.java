package com.akash.rest.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlers {
	
	/*@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public ResponseEntity<List<String>> handleMethodException(MethodArgumentNotValidException e){
		
		List<FieldError> fErrors = e.getFieldErrors();
		List<String> errors = null; 
		fErrors.stream().forEach(error -> errors.add(error.toString()));
		return new ResponseEntity(errors, HttpStatus.BAD_REQUEST);
		
	}*/
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity<String> handleMethodException(Exception e){
		
		e.printStackTrace();
		
		return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}

package com.ty.handleexceptionboot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyAppExceptionController extends ResponseEntityExceptionHandler{

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ResponseStructure<String>> handleNullPointerException(NullPointerException exception)
	{
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatuscode(HttpStatus.BAD_REQUEST.value());
		responseStructure.setMessage("Message : "+exception.getMessage());
		responseStructure.setData("Dont Deal With Null");
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(ArithmeticException.class)
	public void me()
	{
		
	}
}

package com.hospital.GlobalExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import customExceptionss.AgeCheckException;
import customExceptionss.IdNotFoundException;
import customExceptionss.TabletNotFoundException;

@RestControllerAdvice
public class GlobalExceptions {
//	@ExceptionHandler(AgeCheckException.class)
//	public String gettablet() {
//		return "Age is low";
		@ExceptionHandler(AgeCheckException.class)
		public  ResponseEntity<Object> getage(AgeCheckException f) {
			return new ResponseEntity<Object>(f.getMessage(),HttpStatus.BAD_REQUEST);
			
		}
		@ExceptionHandler(TabletNotFoundException.class)
		public ResponseEntity<Object> gettab() {
			return new ResponseEntity<Object>("check the tablet name",HttpStatus.GATEWAY_TIMEOUT);
		}
//		@ExceptionHandler(IdNotFoundException.class)
//		public ResponseEntity<Object> handlers(){
//			return new ResponseEntity<Object>("Invalid Id Please enter the valid Id",HttpStatus.BAD_REQUEST);
//		}
	
		
	

}

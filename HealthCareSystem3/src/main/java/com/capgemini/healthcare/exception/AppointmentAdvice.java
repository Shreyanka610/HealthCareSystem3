package com.capgemini.healthcare.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppointmentAdvice {
	@ExceptionHandler(value = {AppointmentException.class})
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	
	/***************************************************************************************************
	 * Method       handleException1
	 * Description   To handle the exception and displaying particular Http Status message.
	 * 
	 * Created By    Shreyanka Agarwal
	 * Created Date   12-MAY-2020
     ****************************************************************************************************/
	
	public ErrorInfo handleException1(Exception ex) {
		return new ErrorInfo(ex.getMessage());
	}
}

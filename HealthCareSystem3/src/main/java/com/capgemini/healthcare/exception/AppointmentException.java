package com.capgemini.healthcare.exception;

public class AppointmentException extends Exception{	
	private static final long serialVersionUID = 1L;
	
	/***************************************************************************************************
	 * Method       AppointmentException
	 * Description   It is the custom exception which displays the particular message
	 * 
	 * Created By    Shreyanka Agarwal
	 * Created Date   12-MAY-2020
     ****************************************************************************************************/
	
	
	
	public AppointmentException(String message) {
		super(message);
	}

	
}

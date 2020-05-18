package com.capgemin.healthcare.service;

import java.util.List;

import com.capgemin.healthcare.dto.AppointmentDto;
import com.capgemin.healthcare.entity.Appointment;

/***************************************************************************************************
 * @author shreyanka Agarwal
 * Description   It is service interface that provide the methods for adding new appointment , show all
 *                appointment and deleting appointment and further implemented by service implementation 
 *    
 *version         1.0
 *Created Date    11-MAY-2020                
 * 
 ****************************************************************************************************/

public interface AppointmentService
{
	  List<Appointment> showallappointment();
	  
	  Appointment saveAppointment(AppointmentDto appointment);
	  
	  void deleteAppointment(int appointmentId);
	}
	



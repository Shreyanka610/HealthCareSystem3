package com.capgemin.healthcare.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.capgemin.healthcare.dto.AppointmentDto;
import com.capgemin.healthcare.entity.Appointment;
import com.capgemin.healthcare.entity.DiagnosticCenter;
import com.capgemin.healthcare.entity.Test;
import com.capgemin.healthcare.service.AppointmentService;
import com.capgemini.healthcare.exception.AppointmentException;


@CrossOrigin(origins="http://localhost:4200")
@RestController


public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;
	
	
	@GetMapping("/centers")
	public ResponseEntity<List<DiagnosticCenter>> getAllCenters()
	{
		return new ResponseEntity<List<DiagnosticCenter>>(appointmentService.getAllCenters(),HttpStatus.OK);
	}

	@GetMapping("/tests")
	public ResponseEntity<List<Test>> getAllTests()
	{
		return new ResponseEntity<List<Test>>(appointmentService.getAllTests(),HttpStatus.OK);
	}

	@PutMapping("/approve")
	public ResponseEntity<String> approveAppointment(@RequestBody Integer appId)throws AppointmentException
	{
		return new ResponseEntity<String>(appointmentService.approveAppointment(appId),HttpStatus.OK);
	}
	
	/**************************************************************************************************
	 * Method       viewAllAppointment
	 * Description  To view all the appointments inserted in the database
	 * 
	 * Created By    Shreyanka Agarwal
	 * Created Date   08-MAY-2020
	 ***************************************************************************************************/
	
	@GetMapping("/viewAppointments")
	public ResponseEntity<List<Appointment>> getAllAppointment()
	{
		return ResponseEntity.ok().body(appointmentService.showallappointment());
	}


	/***************************************************************************************************
	 * Method       makeAppointment
	 * Description  To add the appoinments inserted in the database
	 * 
	 * Created By    Shreyanka Agarwal
	 * Created Date   08-MAY-2020
	 *****************************************************************************************************/
	
	@PostMapping("/makeAppointment")
	public ResponseEntity<String> saveAppointment(@RequestBody AppointmentDto appointmentDto, BindingResult bindingResult)
	throws AppointmentException
	{
		System.out.println("JSON data:"+appointmentDto);
		
		String err = "";
		if (bindingResult.hasErrors()) 
		{
			List<FieldError> errors = bindingResult.getFieldErrors();
			for (FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new AppointmentException(err);
		}
		try {
			appointmentService.saveAppointment(appointmentDto);
			
			return new ResponseEntity<String>("Appointmnet added successfully wait for the approval", HttpStatus.OK);
			}
		catch (Exception ex)
		{
			throw new AppointmentException(ex.getMessage());
		}
	}
	
	
	/***************************************************************************************************
	 * Method       deleteAppointment
	 * Description  To delete the appointments given by particular id
	 * @throws AppointmentException- It is raised if the particular id which is to be deleted does not 
	 *                                exist in database
	 * Created By    Shreyanka Agarwal
	 * Created Date   09-MAY-2020
	 *****************************************************************************************************/
	
	
	  @DeleteMapping("/deleteAppointment/{id}")
	   public ResponseEntity<String>deleteAppointment(@PathVariable int testId) throws AppointmentException
	  { 
		  try { 
			  appointmentService.deleteAppointment(testId);
	  return new ResponseEntity<String>("Test deleted",HttpStatus.OK);
	  }
	  catch(Exception ex) { 
		  
		  throw new AppointmentException("Appointmnet Id is not exists");
		  }
		  }
	  
	 

}


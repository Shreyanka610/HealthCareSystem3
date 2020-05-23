package com.capgemin.healthcare.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemin.healthcare.dao.AppointmentDao;
import com.capgemin.healthcare.dao.DiagnosticCenterDao;
import com.capgemin.healthcare.dao.TestDao;
import com.capgemin.healthcare.dao.UsersDao;
import com.capgemin.healthcare.dto.AppointmentDto;
import com.capgemin.healthcare.entity.Appointment;
import com.capgemin.healthcare.entity.DiagnosticCenter;
import com.capgemin.healthcare.entity.Test;
import com.capgemin.healthcare.entity.Users;
import com.capgemini.healthcare.exception.AppointmentException;
@Transactional
@Service
public  class AppointmentServiceImpl implements AppointmentService 
{
	@Autowired
	private AppointmentDao appointmentDao;
	@Autowired
	private TestDao testDao;
	@Autowired
	private UsersDao usersDao;
	@Autowired
	private DiagnosticCenterDao diagnosticCenterDao;
	
	
	
	/***************************************************************************************************
	 * Method       saveAppointment
	 * Description  To implement the method which save the appointment
	 * 
	 * Created By    Shreyanka Agarwal
	 * Created Date   010-MAY-2020
	 *****************************************************************************************************/
	
	@Override
	public Appointment saveAppointment(AppointmentDto appointmentDto) throws AppointmentException
	{	
			Optional<Users> user=usersDao.findById(appointmentDto.getUserId());
			if(user==null)throw new  AppointmentException("User does not exists.");
			
			Optional<DiagnosticCenter> diagnosticCenter=diagnosticCenterDao.findById(appointmentDto.getCenterId());
			if(diagnosticCenter==null)throw new  AppointmentException("Center does not exists.");
			
			Optional<Test> test=testDao.findById(appointmentDto.getTestId());
			if(test==null)throw new  AppointmentException("Test does not exists.");
			
			Appointment appointment=new Appointment(appointmentDto.getAppointmentDate(), false, user.get(), diagnosticCenter.get(), test.get());
			return appointmentDao.save(appointment);	 
	}
	
	
	/***************************************************************************************************
	 * Method       showallAppointment
	 * Description   To implement the method which list all the appointment
	 * 
	 * Created By    Shreyanka Agarwal
	 * Created Date   10-MAY-2020
     ****************************************************************************************************/
	
	@Override
   public List<Appointment> showallappointment()
	{
		// TODO Auto-generated method stub
		return this.appointmentDao.findAll();
	}
	
	
	/***************************************************************************************************
	 * Method       deleteAppointment
	 * Description   To implement the method which delete the particular appointment
	 * 
	 * Created By    Shreyanka Agarwal
	 * Created Date   10-MAY-2020
     ****************************************************************************************************/
	
	
	  @Override public void deleteAppointment(int AppointmentId)
	  {
	  appointmentDao.deleteById(AppointmentId); // TODO Auto-generated method stub
	  
	  }


	@Override
	public List<DiagnosticCenter> getAllCenters() {
		// TODO Auto-generated method stub
		return diagnosticCenterDao.findAll();
	}
	
	@Override
	public List<Test> getAllTests() {
		// TODO Auto-generated method stub
		return testDao.findAll();
	}


	@Override
	public String approveAppointment(Integer appId)throws AppointmentException {
		// TODO Auto-generated method stub
		Optional<Appointment> appointement=appointmentDao.findById(appId);
		if(appointement==null) {
			
			throw new AppointmentException("Appointment does not exists");
		}
		appointement.get().setApproved(true);
			
		return "Appointment Approved";
	}	 

	}
	

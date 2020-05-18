package com.capgemin.healthcare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemin.healthcare.entity.Appointment;

public interface AppointmentDao extends JpaRepository<Appointment, Integer>
{

	List<Appointment> findAll();
	

}

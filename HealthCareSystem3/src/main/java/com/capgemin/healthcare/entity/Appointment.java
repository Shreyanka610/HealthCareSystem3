package com.capgemin.healthcare.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "Appointment_Details")
public class Appointment 
{
	@Id
	@Column(name = "appointment_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@SequenceGenerator(sequenceName = "appointment_seq", initialValue = 1000, allocationSize = 1, name = "appointment_seq")
	private Integer appointmentId;

	@Column(name = "Appointment_DateAndTime")
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDate appointmentDate;

	@Column(name = "approved")
	private boolean approved;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE}, optional = false)
	@JoinColumn(name = "CENTER_ID", nullable = false)
	private DiagnosticCenter center;
		
	@ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE}, optional = false)
	@JoinColumn(name = "testId",nullable = false)
	private Test test;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_Id", referencedColumnName = "user_Id")
	private Users user;

	public DiagnosticCenter getCenter() {
		return center;
	}

	public void setCenter(DiagnosticCenter center) {
		this.center = center;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}



	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public Users getUsers() {
		return user;
	}

	public void setUsers(Users users) {
		this.user = users;
	}
	

	public Appointment( LocalDate appointmentDate, boolean approved, Users users,DiagnosticCenter center, Test test) {
		super();
		this.appointmentDate = appointmentDate;
		this.approved = approved;
		this.user = users;
		this.center = center;
		this.test = test;
	}

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", appointmentDate=" + appointmentDate + ", approved="
				+ approved + ", center=" + center + ", test=" + test + ", users=" + user + "]";
	}


	
}
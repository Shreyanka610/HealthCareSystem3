package com.capgemin.healthcare.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AppointmentDto
{
	@JsonFormat(pattern = "yyyy-MM-dd")
		private LocalDate appointmentDate;
		
		private Integer testId;
		private Integer userId;
		private Integer	centerId;
		public LocalDate getAppointmentDate() {
			return appointmentDate;
		}
		
		public void setAppointmentDate(LocalDate appointmentDate) {
			this.appointmentDate = appointmentDate;
		}
		public Integer getTestId() {
			return testId;
		}
		public void setTestId(Integer testId) {
			this.testId = testId;
		}
		public Integer getUserId() {
			return userId;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		public Integer getCenterId() {
			return centerId;
		}
		public void setCenterId(Integer centerId) {
			this.centerId = centerId;
		}
		public AppointmentDto(LocalDate appointmentDate, Integer testId, Integer userId, Integer centerId) {
			super();
			this.appointmentDate = appointmentDate;
			this.testId = testId;
			this.userId = userId;
			this.centerId = centerId;
		}
		@Override
		public String toString() {
			return "AppointmentDto [appointmentDate=" + appointmentDate + ", testId=" + testId + ", userId=" + userId
					+ ", centerId=" + centerId + "]";
		}
		public AppointmentDto() {
			super();
			// TODO Auto-generated constructor stub
		}
		


}


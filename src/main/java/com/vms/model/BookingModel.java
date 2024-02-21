package com.vms.model;

import java.sql.Date;

public class BookingModel {
	private String doctorName;
	private Date date;
	private String vaccinationType;
	private int babyId;

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getVaccinationType() {
		return vaccinationType;
	}

	public void setVaccinationType(String vaccinationType) {
		this.vaccinationType = vaccinationType;
	}
	
	

	public int getBabyId() {
		return babyId;
	}

	public void setBabyId(int babyId) {
		this.babyId = babyId;
	}

	@Override
	public String toString() {
		return "BookingModel [doctorName=" + doctorName + ", date=" + date + ", vaccinationType=" + vaccinationType
				+ ", babyId=" + babyId + "]";
	}

}

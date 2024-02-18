package com.vms.model;

import java.sql.Date;

public class BabyBeen {
	private int babyId;
	private String name;
	private Date dob;
	private String gender;
	private String fatherName;
	private String motherName;
	private String placeOfBirth;

	public int getBabyId() {
		return babyId;
	}

	public void setBabyId(int babyId) {
		this.babyId = babyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	@Override
	public String toString() {
		return "BabyBeen [babyId=" + babyId + ", name=" + name + ", dob=" + dob + ", gender=" + gender + ", fatherName="
				+ fatherName + ", motherName=" + motherName + ", placeOfBirth=" + placeOfBirth + "]";
	}

}

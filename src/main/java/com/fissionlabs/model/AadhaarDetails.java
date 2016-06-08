package com.fissionlabs.model;

import java.util.Date;

public class AadhaarDetails {

	private String registrar;
	private String enrolmentAgency;
	private String state;
	private String district;
	private String subDistrict;
	private Number pinCode;
	private String gender;
	private Integer age;
	private Integer aadhaarGenerated;
	private Integer enrolment;
	private Date date;
	/*private Integer residentsProvidingEmail;
	private Integer residentsProvidingMobileNumber;*/

	public AadhaarDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AadhaarDetails(String registrar, String enrolmentAgency,
			String state, String district, String subDistrict, Number pinCode,
			String gender, Integer age, Integer aadhaarGenerated,Date date,
			Integer enrolment/*, Integer residentsProvidingEmail,
			Integer residentsProvidingMobileNumber*/) {
		super();
		this.registrar = registrar;
		this.enrolmentAgency = enrolmentAgency;
		this.state = state;
		this.district = district;
		this.subDistrict = subDistrict;
		this.pinCode = pinCode;
		this.gender = gender;
		this.age = age;
		this.aadhaarGenerated = aadhaarGenerated;
		this.enrolment = enrolment;
		this.date=date;
		/*this.residentsProvidingEmail = residentsProvidingEmail;
		this.residentsProvidingMobileNumber = residentsProvidingMobileNumber;*/
	}
	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRegistrar() {
		return registrar;
	}

	public void setRegistrar(String registrar) {
		this.registrar = registrar;
	}

	public String getEnrolmentAgency() {
		return enrolmentAgency;
	}

	public void setEnrolmentAgency(String enrolmentAgency) {
		this.enrolmentAgency = enrolmentAgency;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getSubDistrict() {
		return subDistrict;
	}

	public void setSubDistrict(String subDistrict) {
		this.subDistrict = subDistrict;
	}

	public Number getPinCode() {
		return pinCode;
	}

	public void setPinCode(Number pinCode) {
		this.pinCode = pinCode;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAadhaarGenerated() {
		return aadhaarGenerated;
	}

	public void setAadhaarGenerated(Integer aadhaarGenerated) {
		this.aadhaarGenerated = aadhaarGenerated;
	}

	public Integer getEnrolment() {
		return enrolment;
	}

	public void setEnrolment(Integer enrolment) {
		this.enrolment = enrolment;
	}

	/*public Integer getResidentsProvidingEmail() {
		return residentsProvidingEmail;
	}

	public void setResidentsProvidingEmail(Integer residentsProvidingEmail) {
		this.residentsProvidingEmail = residentsProvidingEmail;
	}

	public Integer getResidentsProvidingMobileNumber() {
		return residentsProvidingMobileNumber;
	}

	public void setResidentsProvidingMobileNumber(
			Integer residentsProvidingMobileNumber) {
		this.residentsProvidingMobileNumber = residentsProvidingMobileNumber;
	}*/

}

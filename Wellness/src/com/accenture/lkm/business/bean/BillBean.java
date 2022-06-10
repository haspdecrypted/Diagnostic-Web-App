package com.accenture.lkm.business.bean;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class BillBean {
	private Integer billNo;
	@NotBlank(message="Patient Name should have length between 3 and 30")
	private String patientName;
	@NotNull(message="Please select the Test")
	private Integer testId;
	@NotNull(message="Date of Collection should not be empty")
	private Date dateOfCollection;
	@Min(value = 0,message="Paid amount must be positive value")
	@NotNull(message="Paid Amount should not be empty")
	private Double paidAmount;
	
	private String testName;
	
	private Double balanceAmount;
	
	public Integer getBillNo() {
		return billNo;
	}

	public void setBillNo(Integer billNo) {
		this.billNo = billNo;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public Date getDateOfCollection() {
		return dateOfCollection;
	}

	public void setDateOfCollection(Date dateOfCollection) {
		this.dateOfCollection = dateOfCollection;
	}

	public Double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public Double getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(Double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

}

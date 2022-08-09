package com.ccookat;

public class CustomerDTO {

	private String customerId;
	private String customerPwd;
	private String customerPwd2;
	private String customerName;
	private String customerEmail;
	private String customerTel;
	private String customerCreated;
	//addr 1/2 로 바꿀거면 나중에 담당하는사람이 하기
	private String customerZipcode;
	private String customerAddr1;
	private String customerAddr2;
	
	
	public String getCustomerAddr1() {
		return customerAddr1;
	}
	public void setCustomerAddr1(String customerAddr1) {
		this.customerAddr1 = customerAddr1;
	}
	public String getCustomerAddr2() {
		return customerAddr2;
	}
	public void setCustomerAddr2(String customerAddr2) {
		this.customerAddr2 = customerAddr2;
	}

	public String getCustomerZipcode() {
		return customerZipcode;
	}
	public void setCustomerZipcode(String customerZipcode) {
		this.customerZipcode = customerZipcode;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerPwd() {
		return customerPwd;
	}
	public void setCustomerPwd(String customerPwd) {
		this.customerPwd = customerPwd;
	}
	public String getCustomerPwd2() {
		return customerPwd2;
	}
	public void setCustomerPwd2(String customerPwd) {
		this.customerPwd2 = customerPwd;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerTel() {
		return customerTel;
	}
	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}
	public String getCustomerCreated() {
		return customerCreated;
	}
	public void setCustomerCreated(String customerCreated) {
		this.customerCreated = customerCreated;
	}
	
	
	
	
}

package com.ccookat;

public class CustomerOrderDTO {

	private int orderNum;
	private String customerId;
	private int itemNum;
	private int cartNum;
	private String customerOrderName;
	private String customerOrderZipCode;
	private String customerOrderAddr1;
	private String customerOrderAddr2;
	private String customerOrderTel;
	private String customerOrderPay;
	private String customerMemo;
	
	
	
	public String getCustomerOrderAddr1() {
		return customerOrderAddr1;
	}
	public void setCustomerOrderAddr1(String customerOrderAddr1) {
		this.customerOrderAddr1 = customerOrderAddr1;
	}
	public String getCustomerOrderAddr2() {
		return customerOrderAddr2;
	}
	public void setCustomerOrderAddr2(String customerOrderAddr2) {
		this.customerOrderAddr2 = customerOrderAddr2;
	}
	public String getCustomerMemo() {
		return customerMemo;
	}
	public void setCustomerMemo(String customerMemo) {
		this.customerMemo = customerMemo;
	}
	public int getCartNum() {
		return cartNum;
	}
	public void setCartNum(int cartNum) {
		this.cartNum = cartNum;
	}

	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public int getItemNum() {
		return itemNum;
	}
	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}
	public String getCustomerOrderName() {
		return customerOrderName;
	}
	public void setCustomerOrderName(String customerOrderName) {
		this.customerOrderName = customerOrderName;
	}
	public String getCustomerOrderZipCode() {
		return customerOrderZipCode;
	}
	public void setCustomerOrderZipCode(String customerOrderZipCode) {
		this.customerOrderZipCode = customerOrderZipCode;
	}
	
	public String getCustomerOrderTel() {
		return customerOrderTel;
	}
	public void setCustomerOrderTel(String customerOrderTel) {
		this.customerOrderTel = customerOrderTel;
	}
	public String getCustomerOrderPay() {
		return customerOrderPay;
	}
	public void setCustomerOrderPay(String customerOrderPay) {
		this.customerOrderPay = customerOrderPay;
	}
	
	
	
	
}

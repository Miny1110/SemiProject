package com.ccookat;

public class OrderDetailDTO {
	
	private int orderNum;
	private String customerId;
	private int itemNum;
	private String itemName;
	private int itemCount;
	private int cartTotPrice;
	private String itemImage1;
	
	
	public String getItemImage1() {
		return itemImage1;
	}
	public void setItemImage1(String itemImage1) {
		this.itemImage1 = itemImage1;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
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
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	public int getCartTotPrice() {
		return cartTotPrice;
	}
	public void setCartTotPrice(int cartTotPrice) {
		this.cartTotPrice = cartTotPrice;
	}
	
	

}

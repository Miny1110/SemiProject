package com.ccookat;

public class CartDTO {

	private int cartNum;
	private String customerId;
	private int itemNum;
	private int cartItemCount;
	private int cartTotPrice;
	
	
	public int getCartNum() {
		return cartNum;
	}
	public void setCartNum(int cartNum) {
		this.cartNum = cartNum;
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
	public int getCartItemCount() {
		return cartItemCount;
	}
	public void setCartItemCount(int cartItemCount) {
		this.cartItemCount = cartItemCount;
	}
	public int getCartTotPrice() {
		return cartTotPrice;
	}
	public void setCartTotPrice(int cartTotPrice) {
		this.cartTotPrice = cartTotPrice;
	}
	
	
	
}

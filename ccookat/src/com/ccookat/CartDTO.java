package com.ccookat;

public class CartDTO {

	private int cartNum;
	private String customerId;
	private int cartItemCount;
	private int cartTotPrice;
	private int itemNum;
	private int itemPrice;
	private String itemName;
	private String itemImage1;
	private int itemDiscount;
	
	
	public int getItemDiscount() {
		return itemDiscount;
	}
	public void setItemDiscount(int itemDiscount) {
		this.itemDiscount = itemDiscount;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemImage1() {
		return itemImage1;
	}
	public void setItemImage1(String itemImage1) {
		this.itemImage1 = itemImage1;
	}
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
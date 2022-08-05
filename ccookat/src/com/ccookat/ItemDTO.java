package com.ccookat;

public class ItemDTO {

	private int itemNum;
	private String itemName;
	private int itemCount;
	private int itemPrice;
	private int itemDiscount;
	private String itemType;
	private String itemContent;
	private String itemImage1;
	private String itemImage2;
	private String itemImage3;
	private String itemImage4;
	private int itemStock;
	private int itemHitCount;
	
	
	public int getItemNum() {
		return itemNum;
	}
	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemDiscount() {
		//itemDiscount = (itemPrice * (100-itemDiscount) / 100);
		return itemDiscount;
	}
	
	public void setItemDiscount(int itemDiscount) {
		this.itemDiscount = itemDiscount;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getItemContent() {
		return itemContent;
	}
	public void setItemContent(String itemContent) {
		this.itemContent = itemContent;
	}
	public String getItemImage1() {
		return itemImage1;
	}
	public void setItemImage1(String itemImage1) {
		this.itemImage1 = itemImage1;
	}
	public String getItemImage2() {
		return itemImage2;
	}
	public void setItemImage2(String itemImage2) {
		this.itemImage2 = itemImage2;
	}
	public String getItemImage3() {
		return itemImage3;
	}
	public void setItemImage3(String itemImage3) {
		this.itemImage3 = itemImage3;
	}
	public String getItemImage4() {
		return itemImage4;
	}
	public void setItemImage4(String itemImage4) {
		this.itemImage4 = itemImage4;
	}
	public int getItemStock() {
		return itemStock;
	}
	public void setItemStock(int itemStock) {
		this.itemStock = itemStock;
	}
	public int getItemHitCount() {
		return itemHitCount;
	}
	public void setItemHitCount(int itemHitCount) {
		this.itemHitCount = itemHitCount;
	}
	
	
	
	
}

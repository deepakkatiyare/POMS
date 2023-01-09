package com.poms.model;

public class OrderedItem {
	private int orderId;
	private String itemName;
	private short price;
	public OrderedItem(int orderId, String itemName, short price) {
		super();
		this.orderId = orderId;
		this.itemName = itemName;
		this.price = price;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public short getPrice() {
		return price;
	}
	public void setPrice(short price) {
		this.price = price;
	}
	
}

package com.revature.poms.model;

import java.util.Map;

public class Order {
	private String customerName;
	private String customerContact;
	private String deliveryAddress;
	private String deliveryStatus;
	private int price;
	private Map<String, Integer> itemList;

	public Order() {
		super();
	}

	public Order(String customerName, String customerContact, String deliveryAddress, Map<String, Integer> itemList,
			String deliveryStatus, int price) {
		this.customerName = customerName;
		this.customerContact = customerContact;
		this.deliveryAddress = deliveryAddress;
		this.deliveryStatus = deliveryStatus;
		this.itemList = itemList;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public Map<String, Integer> getItemList() {
		return itemList;
	}

	public void setItemList(Map<String, Integer> itemList) {
		this.itemList = itemList;
	}

	@Override
	public boolean equals(Object obj) {
		Order order = null;
		if (obj instanceof Order)
			order = (Order) obj;
		if (this == order)
			return true;
		else {
			if (this.getCustomerName().equals(order.getCustomerName())
					&& this.getCustomerContact().equals(order.getCustomerContact())
					&& this.getDeliveryAddress().equals(order)) {
				return true;
			}
			return false;
		}
	}

	@Override
	public String toString() {
		return "Order [customerName=" + customerName + ", customerContact=" + customerContact + ", deliveryAddress="
				+ deliveryAddress + ", deliveryStatus=" + deliveryStatus + "]";
	}

}

package com.poms.model;

public class Order {
	private int orderId;
	private String customerName;
	private String customerContact;
	private String deliveryAddress;
	private boolean deliveryStatus;
	public Order(int orderId, String customerName, String customerContact, String deliveryAddress,
			boolean deliveryStatus) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.customerContact = customerContact;
		this.deliveryAddress = deliveryAddress;
		this.deliveryStatus = deliveryStatus;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	public boolean isDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(boolean deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	
}

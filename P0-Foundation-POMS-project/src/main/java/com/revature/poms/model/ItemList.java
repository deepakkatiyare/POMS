package com.revature.poms.model;

public class ItemList {
	private  int id;
	private String itemName;
	private int price;
	public ItemList() {
		super();
	}
	public ItemList(int id,String itemName,int price) {
		this.id = id;
		this.price = price;
		this.itemName = itemName;
	}
	public static ItemList[] createItem() {
		ItemList[] list  =  new ItemList[10];
		list[0]=new ItemList(1, "Extra Cheese Chicken Exotic",99);
		list[1]=new ItemList(2,"mozerrella Chicken Exotic",199);
		list[2]=new ItemList(3,"Extra Cheese Smoked Chicken",129);
		list[3]=new ItemList(4,"jalapeno Smoked Chicken",139);
		list[4]=new ItemList(5,"mozerrella Smoked Chicken",149);
		list[5]=new ItemList(6,"jalapeno Chicken Fiesta",159);
		list[6]=new ItemList(7,"Black Olives Chicken Fiesta",169);
		list[7]=new ItemList(8,"mozerrella Chicken Fiesta",179);
		list[8]=new ItemList(9,"Extra Cheese Chicken Fiesta",189);
		list[9]=new ItemList(10,"Extra Cheese Peri-Peri Chicken",299);
		return list; 
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
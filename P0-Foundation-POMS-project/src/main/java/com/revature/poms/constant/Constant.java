package com.revature.poms.constant;

public class Constant {
	public static final String WELCOME_MESSAGE 		= "************WELCOME TO PIZZA STORE************\n";
	public static final String END_MESSAGE 			= "\n************THANK YOU************";
	public static final String DETAIL_MESSAGE 		= "************SHOWING DETAILS************\n";	
	public static final String PlACE_ORDER 			= "Press 1: For Placing Order";
	public static final String GET_ORDER_DETAILS	= "Press 2: To get Item Details";
	public static final String UPDATE_ORDER_DETAILS = "Press 3: For Updating Order Details";
	public static final String CANCEL_ORDER 		= "Press 4: For Cancelling Order";
	public static final String GET_CANCEL_DETAIL 	= "Press 5: To get Cancel Order Details";
	public static final String ORDER_DETAILS 		= "Enter order details:-";
	public static final String CUSTOMER_NAME 		= "Enter the name of customer:-";
	public static final String DELIVERY_ADDRES 		= "Enter the delivery address:-";	
	public static final String CUSTOMER_CONTACT 	= "Enter the contact number:-";
	public static final String DELIVERY_STATUS 		= "Enter the delivery status Either confirmed or cancelled:-";
	public static final String PUT_ORDER_ID			= "Enter Order Id";	
	public static final String CONTINUE 			= "To continue press Y otherwise N";
	public static final String INSERTION_SUCCESS 	= "Order got placed Succesfully";
	public static final String SELECT_ID 			= "Choose the Id from the above List";
	public static final String ASK_USER 			= "If you want to update again the order press 1 OR press 0!";	
	public static final String COUNT_QUERY 			= "Select count(1) from `order`";	
	public static final String ITEM_lIST 			= "Choose the Items from below list and Press the required number:-";
	public static final String WRONG_ID 			= "wrong id entered";
	public static final String WRONG_FORMAT 		= "format is wrong";
	public static final String ASK_ADD 				= "if you want to add item again press 1 OR press 0! ";
	public static final String ERROR 				= "Error: Value out of range ";
	public static final String CANCEL_ID 			= "Enter the id which you want to cancel";
	public static final String CANCEL_ITEM 			= "Choose the item to be cancelled!";
	public static final String NO_DATA 				= "No data to perform operation";
	public static final String VALUE_INCORRECT 		= "Entered value is not correct";
	public static final String SELECT_ORDER_QUERY 	= "Select * from `order`";
	public static final String ORDER_ID_NOT_EXIST 	= "Order id does not exist";
	public static final String DELETE_SUCCESS		= "deleted successfully";
	public static final String UPDATE_CONTACT_NUMBER= "Press 2: update Contact Number";
	public static final String UPDATE_CUSTOMER_NAME = "Press 1: update Customer Name";
	public static final String UPDATE_SUCCESS 		= "updated successfully";
	public static final String UPDATE_ORDER_CUSTOMER_CONTACT_WHERE_QUERY = "update `order` set customer_contact = ? where order_id = ?";
	public static final String UPDATE_ORDER_CUSTOMER_NAME_WHERE_QUERY = "update `order` set customer_name = ? where order_id = ?";
	public static final String UPDATE_ITEM_LIST 	= "Press 4: update ItemList";
	public static final String UPDATE_DELIVERY_ADDRESS = "Press 3: update Delivery Address";

	public static final String SELECT_ORDERED_ITEM_WHERE_QUERY = "select * from ordered_item where order_id =";
	public static final String DELETE_ORDER_WHERE_QUERY = "delete from `order` where order_id = ?";
	public static final String DELETE_ORDERED_ITEM_WHERE_QUERY = "delete from ordered_item where order_id = ?";
	public static final String SELECT_ORDER_WHERE_QUERY = "select * from `order` where order_id = ?";
	public static final String SELECT_CANCEL_ORDER_QUERY = "select * from cancel_order";
	public static final String SELECT_ORDER_LAST_INDEX_QUERY = "Select last_insert_id() from `order`";
	public static final String INSERT_ORDERED_ITEM_QUERY = "Insert into ordered_item(order_id,item_name,price) values(?,?,?)";
	public static final String INSERT_ORDER_QUERY 	= "Insert into `order`(customer_name,customer_contact,delivery_address,delivery_status,price) values(?,?,?,?,?)";
	public static final String UPDATE_ORDER_DELIVERY_ADDRESS_WHERE_QUERY = "update `order` set delivery_address = ? where order_id = ?";

	public static final String WRONG_ENTRY = "Wrong Entry!!! \n enter correct input";
	public static final String LOGIN_SUCCESSFUL = "Login Successful!!\n";
	public static final String LOGIN_UNSUCCESSFUL = "Login Unsuccessful!!\n";
	public static final String SELECT_ALL_ADMIN = "select * from admin ";
	public static final String ENTER_PASSWORD = "Enter password : ";
	public static final String ENTER_NAME = "Enter username : ";
	public static final String LOGIN = "LOGIN**********************";
	public static final String WELCOME_RECEPTIONIST = "**********Welcome Receptionist**********\n";
	
	public static final String UPDATE_ORDER_PRICE_WHERE = "update `order` set price = ? where order_id = ?";
	public static final String SELECT_PRICE_ORDER_WHERE = "select price from `order` where order_id = ?";
	public static final String INSERT_CANCEL_ORDER_QUERY = "Insert into cancel_order(cancel_reason,cancel_date_time,order_id) values(?,?,?)";

}

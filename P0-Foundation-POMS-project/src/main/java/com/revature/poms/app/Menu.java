package com.revature.poms.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revature.poms.config.DatabaseConnection;
import com.revature.poms.constant.Constant;
import com.revature.poms.model.ItemList;
import com.revature.poms.model.Order;
import com.revature.poms.service.CancelService;
import com.revature.poms.service.OrderService;
import com.revature.poms.daoImpl.OrderDaoImpl;

public class Menu {
	private static Logger log = Logger.getLogger(Menu.class);
	private static Connection conn = DatabaseConnection.getConnection();
	public  static void showMenu() {
		log.info(Constant.WELCOME_MESSAGE);
		log.info(Constant.PlACE_ORDER);
		log.info(Constant.GET_ORDER_DETAILS);
		log.info(Constant.UPDATE_ORDER_DETAILS);
		log.info(Constant.CANCEL_ORDER);
		log.info(Constant.GET_CANCEL_DETAIL);
	}
	public static void showUpdateMenu() {
		log.info(Constant.UPDATE_CUSTOMER_NAME);
		log.info(Constant.UPDATE_CONTACT_NUMBER);
		log.info(Constant.UPDATE_DELIVERY_ADDRESS);
		log.info(Constant.UPDATE_ITEM_LIST);
	}
	public static void menu(Scanner input) {
		char charValue = 'y';
		do {
			showMenu();
			try {
			int value = Integer.parseInt(input.nextLine());
			int n = subMenu(input, value);
			if (n == 0) {
				log.info(Constant.CONTINUE);
			} else {
				menu(input);
			}
			charValue = input.nextLine().charAt(0);
			}catch (NumberFormatException e) {
				log.info(Constant.WRONG_FORMAT);
			}
		} while (charValue == 'y' || charValue == 'Y');
		log.info(Constant.END_MESSAGE);
	}

	private static int subMenu(Scanner input, int value) {
		OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
		switch (value) {
		case 1: {
			try {
				placeOrder(input, orderDaoImpl);
			} catch (SQLException e) {
				log.info(e.getMessage());
			}
			log.info(Constant.INSERTION_SUCCESS);
			return 0;
		}
		case 2: {
			
			try {
				String query = Constant.COUNT_QUERY;
				PreparedStatement statement = null;
				ResultSet rs = null;
					statement = conn.prepareStatement(query);
					rs = statement.executeQuery();
					rs.next();
					if (rs.getInt(1) == 0)
						log.info(Constant.NO_DATA);
					else {
						log.info(Constant.DETAIL_MESSAGE);
				orderDaoImpl.getOrderDetails();
			} }catch (SQLException e) {
				log.info(e.getMessage());
			}
			return 0;
		}
		case 3: {
			try {
				String query = Constant.COUNT_QUERY;
				PreparedStatement statement = null;
				ResultSet rs = null;
					statement = conn.prepareStatement(query);
					rs = statement.executeQuery();
					rs.next();
					if (rs.getInt(1) == 0)
						log.info(Constant.NO_DATA);
					else {
				log.info(Constant.DETAIL_MESSAGE);
				orderDaoImpl.getOrderDetails();
				int condition = 1;
				do {
					log.info(Constant.SELECT_ID);
					int order_id = Integer.parseInt(input.nextLine());
				if(orderDaoImpl.checkOrderId(order_id)) {
					orderDaoImpl.updateOrderDetails(order_id, input);
					log.info(Constant.ASK_USER);
					condition = Integer.parseInt(input.nextLine());
				}
				else {
					log.info(Constant.ORDER_ID_NOT_EXIST);
					condition = 1;
				}
				}while(condition==1);
			} }catch (SQLException e) {
				log.info(e.getMessage());
			}
			catch(NumberFormatException e) {
				log.info(Constant.WRONG_FORMAT);
			}
			return 0;
		}
		case 4: {
			String query = Constant.COUNT_QUERY;
			PreparedStatement statement = null;
			ResultSet rs = null;
			try {
				statement = conn.prepareStatement(query);
				rs = statement.executeQuery();
				rs.next();
				if (rs.getInt(1) == 0)
					log.info(Constant.NO_DATA);
				else {
					orderDaoImpl.getOrderDetails();
					log.info(Constant.CANCEL_ID);
					int x = Integer.parseInt(input.nextLine());
					log.info("Enter the reason for cancellation:");
					String str = input.nextLine();
					orderDaoImpl.deleteOrderDetails(x,str);
				}
			} catch (SQLException e) {
				log.info(e.getMessage());
			}
			return 0;
		}
		case 5:
			try {
				CancelService.getCancelDetails();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		default: {
			log.info(Constant.ERROR + value);
			return -1;
		}
		}
	}
	private static void placeOrder(Scanner input, OrderDaoImpl OrderDaoImpl) throws SQLException {
		Order order = new Order();
		log.info(Constant.CUSTOMER_NAME);
		order.setCustomerName(input.nextLine());
		log.info(Constant.DELIVERY_ADDRES);
		order.setDeliveryAddress(input.nextLine());
		log.info(Constant.CUSTOMER_CONTACT);
		order.setCustomerContact(input.nextLine());
		log.info(Constant.DELIVERY_STATUS);
		order.setDeliveryStatus(input.nextLine());
		new OrderService().getItemList();
		fillItemList(input, order);
		OrderDaoImpl.addOrderDetails(order);
	}
	public static void fillItemList(Scanner input, Order order) {
		Map<String, Integer> item = new HashMap<String, Integer>();
		fillItem(order, input, item);
		int condition = 1;
		do {
			log.info(Constant.ASK_ADD);
			condition = Integer.parseInt(input.nextLine());
			if (condition == 1) {
				fillItem(order, input, item);
			}
		} while (condition == 1);
	}

	public static void fillItem(Order order, Scanner input, Map<String, Integer> item) {

		ItemList[] list = ItemList.createItem();
		try {
			log.info(Constant.SELECT_ID);
			int i = Integer.parseInt(input.nextLine());
			item.put(list[i - 1].getItemName(), list[i - 1].getPrice());
			order.setItemList(item);

		} catch (NumberFormatException e) {
			log.info(Constant.WRONG_FORMAT);
			fillItem(order, input, item);
		} catch (ArrayIndexOutOfBoundsException e) {
			log.info(Constant.WRONG_ID);
			fillItem(order, input, item);
		}
	}
}

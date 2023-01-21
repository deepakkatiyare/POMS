package com.revature.poms.daoImpl;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;

import com.revature.poms.app.Menu;
import com.revature.poms.config.DatabaseConnection;
import com.revature.poms.constant.Constant;
import com.revature.poms.dao.OrderDao;
import com.revature.poms.model.Order;
import com.revature.poms.service.CancelService;
import com.revature.poms.service.OrderService;

public class OrderDaoImpl implements OrderDao {
	private static Connection conn = DatabaseConnection.getConnection();
	private static Logger log = Logger.getLogger(OrderDaoImpl.class);
	public void addOrderDetails(Order order) throws SQLException {
		Set<String> keySet = order.getItemList().keySet();
		Collection<Integer> values = order.getItemList().values();
		Iterator<Integer> iterator = values.iterator();
		int total = 0;
		while (iterator.hasNext()) {
			total += (Integer) iterator.next();
		}
		PreparedStatement preparedStatement = conn.prepareStatement(Constant.INSERT_ORDER_QUERY);
		preparedStatement.setString(1, order.getCustomerName());
		preparedStatement.setString(2, order.getCustomerContact());
		preparedStatement.setString(3, order.getDeliveryAddress());
		preparedStatement.setString(4, order.getDeliveryStatus());
		preparedStatement.setInt(5, total);
		preparedStatement.executeUpdate();
		int id = getLastId(conn);
		Iterator<String> itr = keySet.iterator();
		while (itr.hasNext()) {
			preparedStatement = conn.prepareStatement(Constant.INSERT_ORDERED_ITEM_QUERY);
			String str = itr.next().toString();
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, str);
			preparedStatement.setInt(3, order.getItemList().get(str));
			preparedStatement.executeUpdate();
		}
	}

	public int getLastId(Connection conn) throws SQLException {
		int id = 0;
		PreparedStatement preStatement = conn.prepareStatement(Constant.SELECT_ORDER_LAST_INDEX_QUERY);
		ResultSet rs = preStatement.executeQuery();
		rs.next();
		id = Integer.valueOf(rs.getString(1));
		return id;
	}

	public void getOrderDetails() throws SQLException {
		ResultSet rs = null;
		Statement stmt = null;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(Constant.SELECT_ORDER_QUERY);
		while (rs.next()) {
			int x = rs.getInt(1);
			log.info(x + "--" + rs.getString(2) + "--" + rs.getString(3) + "--" + rs.getString(4) + "--"
					+ rs.getString(5) + "--" + rs.getInt(6));
			Statement statement = conn.createStatement();
			ResultSet reSet = statement.executeQuery(Constant.SELECT_ORDERED_ITEM_WHERE_QUERY + x);
			while (reSet.next()) {
				log.info("--" + reSet.getString(2) + "--" + reSet.getInt(3));
			}
			log.info("\n");
		}
	}

	public boolean checkOrderId(int id) throws SQLException {
		String query = Constant.SELECT_ORDER_WHERE_QUERY;
		PreparedStatement preparedStatement = null;
		ResultSet check = null;
		preparedStatement = conn.prepareStatement(query);
		preparedStatement.setInt(1, id);
		check = preparedStatement.executeQuery();
		return check.next();
	}

	public void deleteOrderDetails(int id, String reason) throws SQLException {
		if (checkOrderId(id)) {

			String query = Constant.INSERT_CANCEL_ORDER_QUERY;
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, reason);
			preparedStatement.setString(2, OrderService.getCurrentDateTime());
			preparedStatement.setInt(3, id);
			preparedStatement.executeUpdate();
			query = Constant.DELETE_ORDERED_ITEM_WHERE_QUERY;
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			query = Constant.DELETE_ORDER_WHERE_QUERY;
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			log.info(Constant.DELETE_SUCCESS);
		} else {
			log.info(Constant.ORDER_ID_NOT_EXIST);
		}
	}

	public void updateOrderDetails(int id, Scanner input) throws SQLException {
		String query = null;
		PreparedStatement preparedStmt = null;
		Menu.showUpdateMenu();
		int value = Integer.parseInt(input.nextLine());
		switch (value) {
		case 1:
			log.info(Constant.CUSTOMER_NAME);
			String newInput = input.nextLine();
			query = Constant.UPDATE_ORDER_CUSTOMER_NAME_WHERE_QUERY;
			try {
				preparedStmt = conn.prepareStatement(query);
				preparedStmt.setString(1, newInput);
				preparedStmt.setInt(2, id);
				preparedStmt.executeUpdate();
			} catch (SQLException e) {
				log.info(e.getMessage());
			}
			log.info(Constant.UPDATE_SUCCESS);
			break;
		case 2:
			log.info(Constant.CUSTOMER_CONTACT);
			newInput = input.nextLine();
			query = Constant.UPDATE_ORDER_CUSTOMER_CONTACT_WHERE_QUERY;
			try {
				preparedStmt = conn.prepareStatement(query);
				preparedStmt.setString(1, newInput);
				preparedStmt.setInt(2, id);
				preparedStmt.executeUpdate();

			} catch (SQLException e) {
				log.info(e.getMessage());
			}
			log.info(Constant.UPDATE_SUCCESS);
			break;
		case 3:
			log.info(Constant.DELIVERY_ADDRES);
			newInput = input.nextLine();
			query = Constant.UPDATE_ORDER_DELIVERY_ADDRESS_WHERE_QUERY;
			try {
				preparedStmt = conn.prepareStatement(query);
				preparedStmt.setString(1, newInput);
				preparedStmt.setInt(2, id);
				preparedStmt.executeUpdate();
			} catch (SQLException e) {
				log.info(e.getMessage());
			}
			log.info(Constant.UPDATE_SUCCESS);
			break;
		case 4:
			int condition = 1;
			try {
				do {
					log.info(Constant.DETAIL_MESSAGE);
					new OrderService().getItemList();
					updateItem(id, input);
					log.info("To continue press 1 or 0;");
					condition = Integer.parseInt(input.nextLine());
				} while (condition == 1);
			} catch (SQLException e) {
				e.printStackTrace();
//				log.info(e.getMessage());
			} catch (NumberFormatException e) {
				log.info(Constant.WRONG_FORMAT);
			}
			break;
		default:
			log.info(Constant.VALUE_INCORRECT);
			break;
		}
	}

	private void updateItem(int id, Scanner input) throws SQLException {
		int condition = 1;
		int value = 0;
		do {
			log.info("\nPress 1: To Add item");
			log.info("Press 2: To Deleted item");
			log.info("Press 3: Exit");
			value = Integer.parseInt(input.nextLine());
			if (value >= 1 && value <= 3)
				condition = 0;
			else {
				log.info(Constant.ERROR);
			}
		} while (condition == 1);
		Order order = new Order();
		switch (value) {
		case 1:
			Menu.fillItemList(input, order);

			Set<String> keySet = order.getItemList().keySet();
			Collection<Integer> values = order.getItemList().values();
			Iterator<Integer> itr = values.iterator();
			int total = 0;
			while (itr.hasNext()) {
				total += (Integer) itr.next();
			}
			Iterator<String> iterator = keySet.iterator();
			while (iterator.hasNext()) {
				PreparedStatement preparedStatement = conn.prepareStatement(Constant.INSERT_ORDERED_ITEM_QUERY);
				String str = iterator.next().toString();
				preparedStatement.setInt(1, id);
				preparedStatement.setString(2, str);
				preparedStatement.setInt(3, order.getItemList().get(str));
				preparedStatement.executeUpdate();
				preparedStatement = conn.prepareStatement(Constant.SELECT_PRICE_ORDER_WHERE);
				preparedStatement.setInt(1,id);
				ResultSet rs= preparedStatement.executeQuery();
				rs.next();
				int n = rs.getInt(1);
				preparedStatement = conn.prepareStatement(Constant.UPDATE_ORDER_PRICE_WHERE);
				preparedStatement.setInt(1, total + n);
				preparedStatement.setInt(2, id);
				preparedStatement.executeUpdate();
			}
			break;
		case 2:
			break;
		case 3:
			break;
		default:
			break;
		}
	}
}

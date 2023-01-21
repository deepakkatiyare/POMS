package com.revature.poms.dao;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.poms.model.Order;
public interface OrderDao {
	public void addOrderDetails(Order order) throws SQLException;
	public void getOrderDetails() throws SQLException;
	public void deleteOrderDetails(int id,String reason) throws SQLException;
	public void updateOrderDetails(int id, Scanner input) throws SQLException;
}

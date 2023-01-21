package com.revature.poms.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.revature.poms.config.DatabaseConnection;
import com.revature.poms.constant.Constant;

public class CancelService {
	private static Connection conn = DatabaseConnection.getConnection();
	private static Logger log = Logger.getLogger(CancelService.class);
	public static void getCancelDetails() throws SQLException {
		log.info(Constant.DETAIL_MESSAGE);
		ResultSet rs = null;
		Statement stmt = null;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(Constant.SELECT_CANCEL_ORDER_QUERY);
		while (rs.next()) {
			log.info(rs.getInt(1) + "--" + rs.getString(2) + "--" + rs.getString(3) + "--" + rs.getInt(4));
			log.info("\n");
		}
	}
}

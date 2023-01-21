package com.revature.poms.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.poms.config.DatabaseConnection;
import com.revature.poms.constant.Constant;
import com.revature.poms.service.CancelService;

public class LoginDaoImpl {
	private static Logger log = Logger.getLogger(LoginDaoImpl.class);
	private static Connection conn = DatabaseConnection.getConnection();
	Scanner sc= new Scanner(System.in);
	public boolean Login()
	{
		boolean check = false;
		log.info(Constant.LOGIN);
	
			log.info(Constant.ENTER_NAME);
			String name=sc.nextLine();
			log.info(Constant.ENTER_PASSWORD);
			String p=sc.nextLine();
			Statement s=null;
			ResultSet rs= null;
			try {
				s=conn.createStatement();
				rs=s.executeQuery(Constant.SELECT_ALL_ADMIN);
				while(rs.next())
				{
					if(rs.getString(1).equals(name)&& rs.getString(5).equals(p)) {
						check = true;
					}
				}
				if(!check)
					log.info(Constant.LOGIN_UNSUCCESSFUL);
				else
					log.info(Constant.LOGIN_SUCCESSFUL);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return check;
		}
	}


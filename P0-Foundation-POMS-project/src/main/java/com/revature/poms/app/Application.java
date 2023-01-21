package com.revature.poms.app;

import java.util.Scanner;

import org.apache.log4j.Logger;
import com.revature.poms.constant.Constant;
import com.revature.poms.daoImpl.LoginDaoImpl;

public class Application {
	private static Logger log = Logger.getLogger(Application.class);

	public static void main(String[] args) {
		log.info(Constant.WELCOME_RECEPTIONIST);
		LoginDaoImpl rp= new LoginDaoImpl();
		boolean check = false;
		while(!check) {
			check = rp.Login();
		}
		Scanner scanner = new Scanner(System.in);
		Menu.menu(scanner);
		scanner.close();
	}
}

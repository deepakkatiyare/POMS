package com.revature.poms.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.revature.poms.model.ItemList;

public class OrderService  {
	private static Logger log = Logger.getLogger(OrderService.class);
	public void  getItemList() {
	ItemList[] list = ItemList.createItem();
	for (ItemList newList : list) {
		log.info(newList.getId() + " " + newList.getItemName() + " " + newList.getPrice());
	}
	}
	public static String getCurrentDateTime() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDateTime = format.format(date);
		return currentDateTime;
	}
}
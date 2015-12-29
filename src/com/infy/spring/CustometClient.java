package com.infy.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustometClient {
	public static void main(String[] args){  
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");  
		 CustomerDao custDao = context.getBean("customerDao",CustomerDao.class);  
		 custDao.createRecord(86269491,"Haryana",300.00,"vanitasharma@gmail.com");  
		 System.out.println("Record created");  
	}

}

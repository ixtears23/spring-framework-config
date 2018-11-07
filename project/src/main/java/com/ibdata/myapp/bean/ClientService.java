package com.ibdata.myapp.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientService {
	
	private static final Logger logger = LoggerFactory.getLogger(ClientService.class);
	
	public ClientService() {
		System.out.println("ExampleBean Constructor");
		logger.debug("ExampleBean Constructor");
	}
	
	public void init() {
		System.out.println("ExampleBean init");
		logger.debug("ExampleBean init");
	}
	
	public void clear() {
		System.out.println("ExampleBean clear");
		logger.debug("ExampleBean clear");
	}
	

}

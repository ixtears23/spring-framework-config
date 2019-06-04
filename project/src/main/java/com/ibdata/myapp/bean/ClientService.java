package com.ibdata.myapp.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientService {
	
	private static final Logger logger = LoggerFactory.getLogger(ClientService.class);
	
	public ClientService() {
		logger.debug("ExampleBean Constructor");
	}
	
	public void init() {
		logger.debug("ExampleBean init");
	}
	
	public void clear() {
		logger.debug("ExampleBean clear");
	}
	

}

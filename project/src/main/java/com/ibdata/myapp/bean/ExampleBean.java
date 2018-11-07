package com.ibdata.myapp.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleBean {
	
	private static final Logger logger = LoggerFactory.getLogger(ExampleBean.class);

	public ExampleBean() {
		logger.debug("ExampleBean Constructor");
	}
	
	public void init() {
		logger.debug("ExampleBean Constructor");
	}
	
	public void clear() {
		logger.debug("ExampleBean Constructor");
	}
	

}

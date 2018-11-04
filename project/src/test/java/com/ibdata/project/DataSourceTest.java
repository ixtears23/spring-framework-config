package com.ibdata.project;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations="classpath:config/root/datasource-buzzy-context.xml")
@PropertySource(value="classpath:properties/database.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class DataSourceTest {
	
	@Autowired
	private DataSource ds;
	
	@Test
	public void testConnection() throws Exception {
		
		try (Connection connection = ds.getConnection()){
			System.out.println(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}

package com.ibdata.project2;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.github.springtestdbunit.annotation.ExpectedDatabase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = { "classpath:/config/*-context.xml" })
@TestExecutionListeners({ 
	DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class 
        })
@DbUnitConfiguration(databaseConnection={"datasource"})	// 기본적으로 dataSource 이름을 찾는다. camel표기법인데 난 전부 소문자로 bean 이름을 등록해서 해당 설정 추가함.
@DatabaseSetup(connection="datasource",  value="classpath:com/ibdata/project2/mapper/userCopy.xml")
public class UserMapperTest {
	
	@Test
//	@DatabaseSetup
//	@ExpectedDatabase
//	@DatabaseSetup(connection="datasource",  value="classpath:com/ibdata/project2/mapper/userCopy.xml")
//	@ExpectedDatabase("classpath:com/ibdata/project2/mapper/userCopy.xml")
	@Transactional
	public void dataTest() {
		
	}


}

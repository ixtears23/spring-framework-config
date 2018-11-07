package com.ibdata.project2.config;

import java.io.IOException;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

//@Configuration
//@PropertySource("classpath:properties/database.properties")
public class SpringBeanConfig {
	
	@Autowired
	Environment env;
	
	private final String MAPPER_LOCATION = "classpath*:com/ibdata/project/**/UserMapper.xml";
	
//	@Bean(name="datasource.buzzy", initMethod="datasourceInit", destroyMethod="datasourceDestroy")
	@Bean(name="datasource.buzzy")
	public DriverManagerDataSource driverManagerDataSource() {
		
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		
		driverManagerDataSource.setDriverClassName(env.getProperty("mysql.buzzy.dirver"));
		driverManagerDataSource.setUrl(env.getProperty("mysql.buzzy.url"));
		driverManagerDataSource.setUsername(env.getProperty("mysql.buzzy.username"));
		driverManagerDataSource.setPassword(env.getProperty("mysql.buzzy.password"));
		
		return driverManagerDataSource;
	}
	
//	public void datasourceInit() {
//		System.out.println("datasourceInit");
//	}
//	
//	public void datasourceDestroy() {
//		System.out.println("datasourceDestroy");
//	}
	
	
	@Bean(name="sqlSessionFactory.buzzy")
	public SqlSessionFactoryBean sqlSessionFactoryBean(@Qualifier("datasource.buzzy") DriverManagerDataSource dataSource) {
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean(); 
		
		sqlSessionFactoryBean.setDataSource(dataSource);
		
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		
		Resource[] resources = null;
		try {
			resources = resolver.getResources(MAPPER_LOCATION);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactoryBean.setMapperLocations(resources);
		
		return sqlSessionFactoryBean;
	}
	
	@Bean("sqlSession")
	public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory.buzzy") SqlSessionFactoryBean sqlSession) {
		
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate((SqlSessionFactory) sqlSession);
		
		return sqlSessionTemplate;
	}
	
}

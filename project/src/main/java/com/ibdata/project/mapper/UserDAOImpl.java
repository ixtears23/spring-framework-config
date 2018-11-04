package com.ibdata.project.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibdata.project.custom.User;

@Repository(value="UserMapper")
public class UserDAOImpl implements UserDAO {
	
	
	private static Logger log = LoggerFactory.getLogger(UserDAOImpl.class);

	@Autowired
	private SqlSession sqlSession;
	
	private String namespace = "com.ibdata.project.mapper.UserMapper";
	
	@Override
	public List<User> selectUser() throws Exception {
		String statement = String.format("%s.%s", namespace, "selectUser");
		List<User> list = sqlSession.selectList(statement);
		
		
		return list;
	}

}

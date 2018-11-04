package com.ibdata.project.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibdata.project.custom.User;
import com.ibdata.project.mapper.UserDAO;

@Service(value="UserService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public List<User> selectUser(User user) throws Exception {
		
		List<User> list = userDAO.selectUser();
		
		return list;
	}

}

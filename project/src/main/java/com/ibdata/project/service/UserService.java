package com.ibdata.project.service;

import java.util.HashMap;
import java.util.List;

import com.ibdata.project.custom.User;

public interface UserService {
	
	public List<User> selectUser(User user) throws Exception;

}

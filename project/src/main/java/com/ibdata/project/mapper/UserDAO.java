package com.ibdata.project.mapper;

import java.util.List;

import com.ibdata.project.custom.User;

public interface UserDAO {

	List<User> selectUser() throws Exception;
}

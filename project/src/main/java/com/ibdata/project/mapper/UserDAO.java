package com.ibdata.project.mapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ibdata.project.custom.User;

public interface UserDAO {

	List<User> selectUser() throws Exception;
}

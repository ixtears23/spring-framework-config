package com.ibdata.project2.service;

import java.util.List;

import com.ibdata.project2.vo.UserCopy;

public interface UserCopyService {
	
	public List<UserCopy> selectUserAll() throws Exception;
	public UserCopy selectUserOne(String id) throws Exception;
	public void insertUser(UserCopy userCopy) throws Exception;
	public void updateUser(UserCopy userCopy) throws Exception;
	
}

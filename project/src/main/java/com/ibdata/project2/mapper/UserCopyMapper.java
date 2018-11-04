package com.ibdata.project2.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ibdata.project2.vo.UserCopy;

@Component("com.ibdata.project2.mapper.UserCopyMapper")
public interface UserCopyMapper {

	public List<UserCopy> selectUserAll() throws Exception;
	public UserCopy selectUserOne(String id) throws Exception;
	public void insertUser(UserCopy userCopy) throws Exception;
	public void updateUser(UserCopy userCopy) throws Exception;
}

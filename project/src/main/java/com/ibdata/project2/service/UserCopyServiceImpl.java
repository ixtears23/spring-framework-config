package com.ibdata.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibdata.project2.vo.UserCopy;
import com.ibdata.project2.mapper.UserCopyMapper;

@Service(value="UserCopyService")
public class UserCopyServiceImpl implements UserCopyService {
	
	@Autowired
	private UserCopyMapper userCopyMapper;
	
	@Override
	public List<UserCopy> selectUserAll() throws Exception {
		
		List<UserCopy> list = userCopyMapper.selectUserAll();
		return list;
	}

	@Override
	public UserCopy selectUserOne(String id) throws Exception {
		
		return userCopyMapper.selectUserOne(id);
	}

	@Override
	public void insertUser(UserCopy userCopy) throws Exception {
		
		
		userCopyMapper.insertUser(userCopy);
//		userCopy.setId(null);
//		userCopyMapper.insertUser(userCopy);
	}

	@Override
	public void updateUser(UserCopy userCopy) throws Exception {
		userCopyMapper.updateUser(userCopy);
		if(1 == 1) {
			throw new Exception();
		}
	}

}

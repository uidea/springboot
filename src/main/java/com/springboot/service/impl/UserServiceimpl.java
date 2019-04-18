package com.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.UserDao;
import com.springboot.model.User;
import com.springboot.service.UserService;

@Service
public class UserServiceimpl implements UserService {

	@Autowired
	private UserDao userDao;

	@SuppressWarnings("unused")

	@Override
	public List<User> getUser() {
		List<User> list = userDao.getUser();
		return userDao.getUser();
	}

	@Override
	public User getUserById(String id) {
		return userDao.getUserById(id);
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUserById(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUserBatch(String[] ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}

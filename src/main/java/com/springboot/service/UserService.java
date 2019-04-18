package com.springboot.service;

import java.util.List;
import com.springboot.model.User;

public interface UserService {
	public List<User> getUser();

	public User getUserById(String id);

	public void addUser(User user);

	public void deleteUserById(String id);

	public void deleteUserBatch(String[] ids);

	public User updateUser(User user);
}

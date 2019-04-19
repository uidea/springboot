package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.UserApi;
import com.springboot.model.User;
import com.springboot.service.UserService;

import io.swagger.annotations.ApiParam;

/**
 * @ClassName: UserController
 * @Function: TODO
 * @Description: TODO
 * @date:2018年7月10日 下午1:40:43
 * 
 * @author liubin
 * @email aguai_liu@163.com
 * @version
 * @since JDK 1.8
 */

@RestController
public class UserApiResource implements UserApi {

	@Autowired
	private UserService userService;

	/**
	 * 获取所有用户信息
	 */
	@Override
	public ResponseEntity<List<User>> getUser() {
		List<User> list = userService.getUser();
		return null;
	}

	/**
	 * 根据ID获取用户信息
	 */
	@Override
	public ResponseEntity<User> getUserById(String id) {
		User user = userService.getUserById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}

package com.movies.review.system.user.service;

import java.util.List;

import com.movies.review.system.user.dto.UserBean;

public interface UserService {
	
	//Save User
	public UserBean saveUser(UserBean userBean) throws Exception;
	
	// Get All User List
	public List<UserBean> getAllUser() throws Exception;
	
	//Get User By Id - Name - Email
	public UserBean getUserById(Long id) throws Exception;
	public List<UserBean> getUserByName(String name) throws Exception;	
	public List<UserBean> getUserByEmail(String email) throws Exception;
	
	//Delete User
	public UserBean deleteUserById(Long id) throws Exception;
	
	//update user
	public UserBean updateUser(Long id, UserBean userBean) throws Exception;
	

}

package com.movies.review.system.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movies.review.system.user.dto.UserBean;
import com.movies.review.system.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// Save User Method
	@PostMapping
	public ResponseEntity<UserBean> saveUser(@RequestBody UserBean userBean) throws Exception{
		userBean = userService.saveUser(userBean);
		return new ResponseEntity<UserBean>(userBean,HttpStatus.CREATED);
	}
	
	//Get All User List
	@GetMapping
	public ResponseEntity<List<UserBean>> getAllUserData() throws Exception{
		return new ResponseEntity<List<UserBean>>(userService.getAllUser(),HttpStatus.OK);
	}
	
	//Get User By Different Parameters
	@GetMapping("/id/{id}")
	public ResponseEntity<UserBean> getUserById(@PathVariable(name = "id") Long id) throws Exception{
		return new ResponseEntity<UserBean>(userService.getUserById(id),HttpStatus.OK);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<List<UserBean>> getUserByName(@PathVariable(name = "name") String name) throws Exception{
		return new ResponseEntity<>(userService.getUserByName(name),HttpStatus.OK);
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<List<UserBean>> getUserByEmail(@PathVariable(name = "email") String email) throws Exception{
		return new ResponseEntity<>(userService.getUserByEmail(email),HttpStatus.OK);
	}
	
	//delete user by id
	@DeleteMapping("/{id}")
	public ResponseEntity<List> deleteUserById(@PathVariable Long id) throws Exception{
		List lists = new ArrayList<>();
		lists.add(userService.deleteUserById(id));
		lists.add("User with id "+id+" is deleted");
		return new ResponseEntity<>(lists,HttpStatus.OK);
	}
	
	//update user details
	@PutMapping("/{id}")
	public ResponseEntity<UserBean> updateUserId(@PathVariable Long id,@RequestBody UserBean userBean) throws Exception{
		userBean = userService.updateUser(id, userBean);
		return new ResponseEntity<UserBean>(userBean,HttpStatus.OK);
	}
} 

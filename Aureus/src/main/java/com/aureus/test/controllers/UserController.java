package com.aureus.test.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aureus.test.common.UserNotFoundException;
import com.aureus.test.entities.UserEntity;
import com.aureus.test.services.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {
	
	@Autowired
	UserService userService;
	
	private final Logger logger=LoggerFactory.getLogger(UserController.class);
	
	@GetMapping(path="/users")
	public List<String> getAllUsers()
	{
		logger.info("getAllUsers Mapping recieved");
		return userService.getAllUsers().stream().map(user->user.toStringDate()).collect(Collectors.toList());
	}
	
	@GetMapping(path="/usersFormat1")
	public List<String> getAllUsersFormat1()
	{
		logger.info("getAllUsers1 Mapping recieved");
		return userService.getAllUsers().stream().map(user->user.toStringDateTime1()).collect(Collectors.toList());
	}
	
	@GetMapping(path="/usersFormat2")
	public List<String> getAllUsersFormat2()
	{
		logger.info("getAllUsers2 Mapping recieved");
		return userService.getAllUsers().stream().map(user->user.toStringDateTime2()).collect(Collectors.toList());
	}
	
	@PostMapping(path="/addUser")
	public String addUser(@RequestBody UserEntity user)
	{
		logger.info("User is getting added");
		try {
			userService.saveUser(user);
			return "User is added succesfully";
		}
		catch(Exception e)
		{
			logger.error("Error while adding the user");
			return "Error while adding the user";
		}
	}
	
	@PostMapping(path="/addUsers")
	public String addUsers(@RequestBody List<UserEntity> users)
	{
		try {
		logger.info("adding multiple users");
		userService.saveAllUsers(users);
		return "Users Are added";
		}
		catch(Exception e)
		{
			logger.error("Error while adding users");
			return "Error while adding the Users";
		}
	}
	
	@GetMapping(path="/getUser/{userid}")
	public UserEntity getUserById(@PathVariable Long userid)
	{
		logger.info("getting user info for user "+userid); 
		return userService.getUserById(userid).orElseThrow(()->new UserNotFoundException("User Not Found"));
	}

}

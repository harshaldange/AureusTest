package com.aureus.test.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aureus.test.entities.UserEntity;
import com.aureus.test.repositories.UserRepository;


@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	private final Logger logger=LoggerFactory.getLogger(UserService.class);
	
	public List<UserEntity> getAllUsers()
	{
		logger.info("Entry in Service:getAllUsers");
		return userRepository.findAll();
	}
	
	public UserEntity saveUser(UserEntity user)
	{
		logger.info("Entry in Service:saveUser");
		return userRepository.save(user);
	}
	
	public List<UserEntity> saveAllUsers(List<UserEntity> users)
	{
		logger.info("Entry in Service: saveAllUsers");
		return userRepository.saveAll(users);
	}
	
	public Optional<UserEntity> getUserById(Long userId)
	{
		logger.info("Entry in Service: getUserById");
		return userRepository.findById(userId);
	}
}

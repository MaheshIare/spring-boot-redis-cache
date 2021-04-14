/**
 * 
 */
package com.java.techhub.redis.demo.service;

import java.util.List;

import com.java.techhub.redis.demo.model.User;

/**
 * @author mahes
 *
 */
public interface UserService {

	User addUser(User user);
	
	User getUser(Integer userId);
	
	List<User> getAllUsers();
	
	User updateUser(Integer userId, User user);
	
	String deleteUser(Integer userId);
}

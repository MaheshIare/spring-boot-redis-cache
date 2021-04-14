/**
 * 
 */
package com.java.techhub.redis.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.java.techhub.redis.demo.model.User;
import com.java.techhub.redis.demo.repository.UserJpaRepository;
import com.java.techhub.redis.demo.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author mahes
 *
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserJpaRepository userJpaRepository;

	@CachePut(value = "user", key = "#user.userId")
	@Override
	public User addUser(User user) {
		log.info("Saving user to db");
		return userJpaRepository.saveAndFlush(user);
	}

	@Cacheable(value = "user", key = "#userId")
	@Override
	public User getUser(Integer userId) {
		log.info("Fetching user from db");
		Optional<User> optional = userJpaRepository.findById(userId);
		return optional.isPresent() ? optional.get() : optional.orElse(null);
	}

	@Cacheable(value = "user")
	@Override
	public List<User> getAllUsers() {
		log.info("Fetching users from db");
		return userJpaRepository.findAll();
	}

	@CachePut(value = "user", key = "#userId")
	@Override
	public User updateUser(Integer userId, User user) {
		log.info("Updating user in db");
		user.setUserId(userId);
		return userJpaRepository.saveAndFlush(user);
	}

	@CacheEvict(value = "user", key = "#userId")
	@Override
	public String deleteUser(Integer userId) {
		log.info("Deleting user from db");
		String response = "Failed to delete the user";
		try {
			userJpaRepository.deleteById(userId);
			response = "Successfully deleted the user with id: " + userId;
		} catch (Exception e) {
			log.error("Exception occured while deleting the user due to: {}", e);
		}
		return response;
	}

}

/**
 * 
 */
package com.java.techhub.redis.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.java.techhub.redis.demo.model.User;
import com.java.techhub.redis.demo.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author mahes
 *
 */
@RestController
@RequestMapping("/api/v1/user")
@Api(description = "Operations pertaining to users in User Store")
public class UserAPIController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "Add a new user to the Users database", response = User.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully saved the user to the datasbase"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Something went wrong while saving the user data") })
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody(required = true) User user) {
		return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
	}

	@ApiOperation(value = "Retrieve a user from the Users database", response = User.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved the user from the datasbase"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Something went wrong while retrieving the user data") })
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUser(@PathVariable(name = "userId", required = true) Integer userId) {
		return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
	}

	@ApiOperation(value = "Retrieve users from the Users database", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved the users from the datasbase"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Something went wrong while retrieving the users data") })
	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
	}

	@ApiOperation(value = "Update a user in the Users database", response = User.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated the user in the datasbase"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Something went wrong while updating the user data") })
	@PutMapping("/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable(name = "userId", required = true) Integer userId,
			@RequestBody(required = true) User user) {
		return new ResponseEntity<>(userService.updateUser(userId, user), HttpStatus.OK);
	}

	@ApiOperation(value = "Delete a user info from the Users database", response = Map.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully deleted the user from the datasbase"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Something went wrong while deleting the user data") })
	@DeleteMapping("/{userId}")
	public ResponseEntity<Map<String, Object>> deleteUser(@PathVariable(name = "userId", required = true) Integer userId) {
		Map<String, Object> map = new HashMap<>();
		String message = userService.deleteUser(userId);
		map.put("message", message);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
}

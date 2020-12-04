/**
 * 
 */
package com.example.users.controllers;

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

import com.example.users.entities.User;
import com.example.users.services.UserService;

/**
 * @author josedominguez
 *
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<List<User>>(service.getUsers(), HttpStatus.OK);
	}

	@GetMapping(value = "/{userId}")
	public ResponseEntity<User> getUserByUserName(@PathVariable("userId") Integer userId) {
		return new ResponseEntity<User>(service.getUserById(userId), HttpStatus.OK);
	}

//
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return new ResponseEntity<User>(service.createUser(user), HttpStatus.CREATED);
	}

	@PutMapping(value = "{userId}")
	public ResponseEntity<User> updateUser(@PathVariable("userId") Integer userId, @RequestBody User user) {
		return new ResponseEntity<User>(service.updateUser(userId, user), HttpStatus.OK);
	}

	@DeleteMapping(value = "{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable("userId") Integer userId) {
		service.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

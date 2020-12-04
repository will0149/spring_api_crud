/**
 * 
 */
package com.example.users.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.users.entities.User;
import com.example.users.repositories.UserRepository;

/**
 * @author josedominguez
 *
 */
@Service
public class UserService {
	@Autowired
	private UserRepository repository;

	public List<User> getUsers() {
		return repository.findAll();
	}

	public User getUserById(Integer userId) {
		Optional<User> result = repository.findById(userId);
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("user id $d doesnt exist", userId));
		}

	}

	public User createUser(User user) {
		repository.save(user);
		return user;
	}

	public User updateUser(Integer userId, User user) {
		Optional<User> result = repository.findById(userId);
		if (result.isPresent()) {
			result.get().setUsername(user.getUsername());
			result.get().setPassword(user.getPassword());
			result.get().setProfile(null);
			result.get().setEmail(user.getEmail());
			repository.save(result.get());
			return result.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("user id $d doesnt exist", userId));
		}

	}

	public void deleteUser(Integer userId) {
		Optional<User> result = repository.findById(userId);
		if (result.isPresent()) {
			repository.delete(result.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("user id $d doesnt exist", userId));
		}
	}

}

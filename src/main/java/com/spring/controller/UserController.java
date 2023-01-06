package com.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.User;
import com.spring.repo.UserRepo;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserRepo userRepo;

	@GetMapping("/users")
	public ResponseEntity<List<User>> findAllUsers() {
		List<User> users = userRepo.findAll();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@GetMapping("/user/{id}")
	public Optional<User> findUserById(@PathVariable(value = "id") long id) {
		return userRepo.findById(id);
		// return new ResponseEntity<>(User, HttpStatus.OK);
	}

	@PutMapping("/user")
	public User saveUser(@Validated @RequestBody User user) {
		return userRepo.save(user);
	}

}

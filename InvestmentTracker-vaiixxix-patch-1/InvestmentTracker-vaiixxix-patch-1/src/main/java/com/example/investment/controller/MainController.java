package com.example.investment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.investment.entity.User;
import com.example.investment.service.ServiceProvider;

@RestController
public class MainController {

	@Autowired
	private ServiceProvider service;
	
	
	@GetMapping("/")
	public String Home() {
		return "Hello";
	}
	
	@PostMapping(path = "/addUsers", consumes = "application/json")
	public User addUser(@RequestBody User user) {
		return service.saveUser(user);
		
	}
	
	@GetMapping(path = "/getUsers")
	public List<User> getUser() {
		return service.getUsers();
		
	}
	
	@GetMapping(path = "/getUsersByName/{username}")
	public Optional<User> getUserByUsername(@PathVariable String username) {
		return service.getUserByUsername(username);
		
	}
	
	@PutMapping(path = "/updateUsers/{username}", consumes = "application/json")
	public User updateUsers(@RequestBody User user,@PathVariable String username) {
		return service.updateUsers(user,username);
		
	}
	
	@DeleteMapping(path = "/deleteUsers/{username}")
	public String deleteUsers(@PathVariable String username) {
		return service.deleteUsers(username);
		
	}
	
	@PostMapping(path = "/login", consumes = "application/json")
	public String login(@RequestBody User user) {
		return service.login(user);
	}
	
	
}

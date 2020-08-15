package com.example.investment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.investment.entity.User;
import com.example.investment.repository.UserInterface;

@Service
public class ServiceProvider {
	@Autowired
	private UserInterface userInterface;
	
	public User saveUser(User user) {
		return userInterface.save(user);
	}

	public List<User> getUsers() {
		return userInterface.findAll();
	}

	public Optional<User> getUserByUsername(String username) {
		return userInterface.findByUsername(username);
	}

	public User updateUsers(User user,String username) {
		User newUser = userInterface.findByUsername(user.getUsername()).orElse(null);
		newUser.setFirstname(user.firstname);
		newUser.setLastname(user.lastname);
		newUser.setEmail(user.email);
		newUser.setMobile(user.mobile);
		newUser.setUserid(user.userid);
		newUser.setUsername(user.username);
		newUser.setPassword(user.password);
		return userInterface.save(newUser);
	}

	public String deleteUsers(String username) {
		//userInterface.deleteByUsername(username);
		User user = userInterface.findByUsername(username).orElse(null);
		userInterface.delete(user);
		return username + "Deleted";
	}

	public String login(User user) {
		User newUser = userInterface.findByUsername(user.getUsername()).orElse(null);
		if(newUser == null) {
			return "Invalid Username";
		}
		else {
			if(newUser.getPassword().matches(user.getPassword()) == false ) {
				return "Invalid Password";
			}else {
				return "Login Succesful";
			}
		}
	}
	
}

package com.stir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stir.exception.ResourceNotFoundException;
import com.stir.model.Credentials;
import com.stir.model.User;
import com.stir.repository.CredentialRepository;
import com.stir.repository.UserRepository;

@RestController
@RequestMapping("rest")
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CredentialRepository credentialRepository;
	
	@PostMapping("/user")
	@CrossOrigin(origins = {"http://localhost:8080"})
	public User createUser(@RequestBody User user) {
		//go to repo(User) and use save method to insert in DB
		return userRepository.save(user);
	}
	
	@GetMapping("/users")
	@CrossOrigin(origins = {"http://localhost:8080"})
	public List<User> getUsers() {
		//go to repo and fetch all users 
		return userRepository.findAll();
	}
	
	@GetMapping("/user/{id}")
	@CrossOrigin(origins = {"http://localhost:8080"})
	public User getUser(@PathVariable("id") int id) {
		//go to repo and fetch user based on id.
		return userRepository.getOne(id);
	}
	
	@PutMapping("/user/{id}")
	@CrossOrigin(origins = {"http://localhost:8080"})
	public User updateUser(@RequestBody User user,@PathVariable("id") int id) {
		//go to repo and fetch existing user based on id
		User u = userRepository.getOne(id);//existing User
		u.setName(user.getName());
		u.setMobile_no(user.getMobile_no());
		u.setEmail(user.getEmail());
		//save u in repo
		return userRepository.save(u);	
	}
	
	@DeleteMapping("/user/{id}")
	@CrossOrigin(origins = {"http://localhost:8080"})
	public void deleteUser(@PathVariable("id") int id) {
		//go to repo and delete based on id
		userRepository.deleteById(id);
	}
	
	@PostMapping("/user/password/{userId}")
	@CrossOrigin(origins = {"http://localhost:8080"})
	public User setPassword(@PathVariable("userId") int userId , @RequestBody Credentials credentials) {
		// go to repo and fetch user info
		User user = userRepository.getOne(userId);//existing
		// save credentials in DB
		credentials.setUsername(user.getEmail());
		Credentials c = credentialRepository.save(credentials);
		
		//set credentials to user
		user.setCredentials(c);
		
		//Update the user
		return userRepository.save(user);
	}
	
	@GetMapping("/login")
	@CrossOrigin(origins = {"http://localhost:8080"})
	public User login(@RequestHeader("username") String username , @RequestHeader("password") String password) {
		
		User u = userRepository.findByEmail(username);
		if(!(u == null)) {
			if(u.getCredentials().getPassword().equals(password)) {
				return u;
			}
		}
		throw new ResourceNotFoundException("Credentials Invalid");
		
		
	}
}

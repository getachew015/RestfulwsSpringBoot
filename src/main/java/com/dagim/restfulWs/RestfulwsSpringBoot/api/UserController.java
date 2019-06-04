package com.dagim.restfulWs.RestfulwsSpringBoot.api;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dagim.restfulWs.RestfulwsSpringBoot.exception.UserNotFoundException;
import com.dagim.restfulWs.RestfulwsSpringBoot.model.User;
import com.dagim.restfulWs.RestfulwsSpringBoot.service.UserDaoService;

@RestController
public class UserController {
	
	@Autowired
	private UserDaoService userService;
	
	@GetMapping("/users")
	public List<User> retiveAllUsers(){
		
		return userService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User findlUser(@PathVariable int id){
		User user = userService.findUser(id);
		if(user==null)
			throw new UserNotFoundException("id - "+ id);
		return user;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> findlUser(@RequestBody User user){
		
		User userSaved = userService.addUser(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}").buildAndExpand(userSaved.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}

}

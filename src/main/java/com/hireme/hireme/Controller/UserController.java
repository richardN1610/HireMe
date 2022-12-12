package com.hireme.hireme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hireme.hireme.dto.NewUserDTO;
import com.hireme.hireme.model.User;
import com.hireme.hireme.service.UserService;

import com.hireme.hireme.exceptions.UserException;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
	

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	
	//the sign up view will be setup by the front-end.
	//once the user click the submit button, the data will be sent to the backend as json format (@responsebody)
	
	@PostMapping("/signup")
	public User createUser(@RequestBody NewUserDTO userDTO) throws UserException {
		System.out.println("user details: " + userDTO);
		return userService.saveUser(userDTO);
	}


	
}

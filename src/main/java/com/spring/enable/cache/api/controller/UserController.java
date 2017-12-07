package com.spring.enable.cache.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.enable.cache.api.model.UserResponse;
import com.spring.enable.cache.api.service.UserService;

@RestController
@RequestMapping("/service")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/getUsersWithoutCache")
	public UserResponse getUsersWithoutCache() {
		return service.getUsers();
	}

	@GetMapping("/getUsersWithCache")
	public UserResponse getUsersWithCache() {
		return service.getUsers(null);
	}
}

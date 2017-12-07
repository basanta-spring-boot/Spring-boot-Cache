package com.spring.enable.cache.api.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.spring.enable.cache.api.model.UserModel;
import com.spring.enable.cache.api.model.UserResponse;
import com.spring.enable.cache.api.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void saveDataOnStartUp() {
		System.out.println("Post construct calling..");
		List<UserModel> users = new ArrayList<>();
		for (int i = 1; i <= 1000; i++) {
			UserModel user = new UserModel();
			user.setName("User" + i);
			user.setProfession("profession" + i);
			user.setAddress(new String[] { "city" + i, "dist" + i, "state" + i });
			users.add(user);
		}
		repository.save(users);
	}

	// without cache
	public UserResponse getUsers() {
		long start = System.currentTimeMillis();
		List<UserModel> users = repository.findAll();
		long end = System.currentTimeMillis();
		long totalTime = end - start;
		System.out.println("Total time : " + totalTime);
		return new UserResponse(true, totalTime, users);
	}

	// with cache
	@Cacheable("users")
	public UserResponse getUsers(String data) {
		long start = System.currentTimeMillis();
		List<UserModel> users = repository.findAll();
		long end = System.currentTimeMillis();
		long totalTime = end - start;
		System.out.println("Total time : " + totalTime);
		return new UserResponse(true, totalTime, users);
	}

}

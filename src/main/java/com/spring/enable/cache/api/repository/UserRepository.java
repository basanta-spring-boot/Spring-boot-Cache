package com.spring.enable.cache.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.enable.cache.api.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

}

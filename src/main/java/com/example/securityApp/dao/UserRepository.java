package com.example.securityApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.securityApp.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByEmailAndPasword(String email,String password);
}

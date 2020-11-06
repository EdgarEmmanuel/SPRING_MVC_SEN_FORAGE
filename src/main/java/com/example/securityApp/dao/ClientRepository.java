package com.example.securityApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.securityApp.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}

package com.example.securityApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.securityApp.entities.Statut;

public interface StatutRepository extends JpaRepository<Statut, Integer> {

}

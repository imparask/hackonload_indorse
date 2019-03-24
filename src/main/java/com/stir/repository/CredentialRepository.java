package com.stir.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stir.model.Credentials;
import com.stir.model.User;

public interface CredentialRepository extends JpaRepository<Credentials, Integer>{
	
}

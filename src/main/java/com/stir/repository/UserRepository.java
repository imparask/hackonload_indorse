package com.stir.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stir.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByEmail(String username);
}

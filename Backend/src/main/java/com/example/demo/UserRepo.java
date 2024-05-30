package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer>
{
	int countByUsername(String username);
	User findByUsername(String username);
	List<User> findByRole(int role);
}

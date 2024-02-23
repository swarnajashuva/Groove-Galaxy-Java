package com.example.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entities.Users;
public interface UsersRepository extends JpaRepository<Users, Integer>
{
	//In DB fetching that email is present or not
	public Users findByEmail(String email);
	
}

package com.example.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.entities.Songs;
import com.example.springboot.entities.Users;
import com.example.springboot.repositories.UsersRepository;
@Service
public class UserServiceImplementation implements UsersService
{
	@Autowired
    UsersRepository repo;
	
	@Override
	public String addUser(Users user)
	{
		repo.save(user);
		return "User is Created and Saved";
	}

	@Override
	public boolean emailExists(String email) 
	{
		//if email is exist it means == null by calling the findByEmail().It is present repo
		if(repo.findByEmail(email)==null)
		{
			//email is not exist 
			return false;
		}
		else
		{
			//Other wise email is exist
			return true;
		}
		
	}

	@Override
	public boolean validUser(String email, String password) 
	{
		//To perform login only we have to check validUser()
		//By performing the findByEmail()only we can consider it.
		Users user=repo.findByEmail(email);
		//Here getting the db password
		String db_password=user.getPassword();
		//checking if it is equal to users password
		if(db_password.equals(password))
		{
			// return both are same
			return true;
		}
		else
		{
			//Other wise
			return false;
		}
	}

	@Override
	public String getRole(String email) 
	{
		/* Users user=repo.findByEmail(email);
		return (user.getRole());*/
		return (repo.findByEmail(email).getRole());
	}

	@Override
	public Users getUser(String email) 
	{
		return repo.findByEmail(email);
	}

	@Override
	public void updateUser(Users user) 
	{
		repo.save(user);
		// TODO Auto-generated method stub
		
	}

}

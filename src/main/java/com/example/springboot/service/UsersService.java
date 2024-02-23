package com.example.springboot.service;

import com.example.springboot.entities.Users;

public interface UsersService 
{
  public String addUser(Users user);
 //Checking users email is exist or not 
  public boolean emailExists(String email);
  
  public boolean validUser(String email,String password);
  
  public String getRole(String email);
  
  public Users getUser(String email);
  
  public void updateUser(Users user);
  
}

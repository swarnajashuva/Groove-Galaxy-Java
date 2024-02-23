package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springboot.entities.Songs;
import com.example.springboot.entities.Users;
import com.example.springboot.service.SongsService;
import com.example.springboot.service.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController 
{
	
	@Autowired
	UsersService userv;
	//Fetching the songs we have to create the reference of songsSservice
	@Autowired
	SongsService songserv;
	@PostMapping("/register")
	//This method represents the registration part
	public String addUser(@ModelAttribute Users user) 
	{
		//checking email is exist or not by calling the emailExist()
		boolean userStatus=userv.emailExists(user.getEmail());
		//if email is not there 
		if(userStatus==false)
		{
			//call addUser(user)
			userv.addUser(user);
			return "registersuccess";
		}
		else
		{
			//if email is already registered ,register other email
			return "registerfail";
			
		}
	}
	//Control is coming from login.html 
	@PostMapping("/login")
	public String validUser(@RequestParam String email,@RequestParam String password,HttpSession session)
	{
		//boolean loginstatus=userv.validUser(email, password);
		//invoking(checking) the Users mail and password both are correct,then call the validUser() present in Service
	    if(userv.validUser(email, password)==true)
	    {
			session.setAttribute("email", email);

	    	//String role=userv.getRole(email);
	    	//If the user is admin
	    	if(userv.getRole(email).equals("admin"))
	    	{
	    	   return "adminhome";
	    	}
	    	else
	    	{
	    		//user is customer
	    	  return "customerhome";
	    	}
	    }
	    else
	    {
	    	//Other wise invalid credentials again re-login
	    	return "loginfail";
	    }
	}
	@GetMapping("/exploreSongs")
	public String exploreSongs(HttpSession session, Model model)
	{
		String email=(String)session.getAttribute("email");
		Users user=userv.getUser(email);
		
		boolean userStatus=user.isPremium();
		if(userStatus == true)
		{
			List<Songs> songslist=songserv.fetchAllSongs();
		    model.addAttribute("songslist", songslist);
		
			return "isPremium";
		}
		else
		{
			return "samplePayment";
		}
	}
	
}

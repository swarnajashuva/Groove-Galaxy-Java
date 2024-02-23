package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
//The purpose NavController is when ever we have to connect with one 
//HTML page to another HTML page we have to make use of NavController
public class NavController
{
	//Control should be coming from index.html
	@GetMapping("/map-add")
	public String registerMap()
	{
		//Control is going to register.html
		return "register";
	}
	
    @GetMapping("/map-login")
	public String loginMap()
	{
		return "login";
	}
    @GetMapping("/map-songs")
    public String mapSongs()
    {
    	return "addsongs";
    }
    @GetMapping("/purchase")
   public String sample()
   {
	   return "samplePayment";
   }
    @GetMapping("/admin-back")
  public String adminHome()
  {
	  return "adminhome";
  }
}

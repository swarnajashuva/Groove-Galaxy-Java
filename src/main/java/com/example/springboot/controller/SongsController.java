package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springboot.entities.Songs;
import com.example.springboot.service.SongsService;


@Controller
public class SongsController 
{
	@Autowired
	SongsService sserv;
	
	@PostMapping("/addsongs")
	public String addSongs(@ModelAttribute Songs song)
	{
		
		boolean status=sserv.songExists(song.getName());
		if(status==false)
		{
			sserv.addSongs(song);
			return "songaddedsuccess";
		}
		else
		{
			return "songexist";
		}
	}
	
	@GetMapping("/map-viewsongs")
	public String viewSongs(Model model)
	{
		List<Songs> songslist=sserv.fetchAllSongs();
		model.addAttribute("songslist", songslist);
		
		return "displaysongs";
	}
    @GetMapping("/map-view")
	public String viewSongsCustomer(Model model)
	{
    	List<Songs> songslist=sserv.fetchAllSongs();
	    model.addAttribute("songslist", songslist);
	
    	boolean primeStatus=true;
    	if(primeStatus==true)
    	{
			return "displaysongs";
		}
    	else 
		{
			return "samplePayment.html";
		}
	}
   
}

package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springboot.entities.PlayList;
import com.example.springboot.entities.Songs;
import com.example.springboot.service.PlayListService;
import com.example.springboot.service.SongsService;

@Controller
public class PlayListController 
{
	@Autowired
	PlayListService pserv;
	
	@Autowired
	SongsService sserv;
	
	@GetMapping("/createplaylist")
    public String createPlayList(Model model)
    {
		//Fetching the songs from songsService
		List<Songs> songslist = sserv.fetchAllSongs();
		//Adding inside the model
		model.addAttribute("songslist", songslist);
		//sending response to createplaylist
		return "createplaylist";
	}
	//Control is coming from createplaylist.html
	@PostMapping("/addplaylist")
	public String addPlayList(@ModelAttribute PlayList playlist)
	{
		// Calling the addPlaylist from playListService to perform creation playList
		pserv.addPlaylist(playlist);
		System.out.println(playlist);
		// Getting the songs from the playList entities
		List<Songs> songslist = playlist.getSongs();
		
		for (Songs song : songslist) 
		{
              song.getPlaylist().add(playlist);
             sserv.updateSong(song);
		}
		return "playlistsuccess";
	}
	
	
	@GetMapping("/viewPlaylist")
	public String viewPlayList(Model model)
	{
		List<PlayList> plist=pserv.fetchPlaylist();
		model.addAttribute("plist", plist);
		return "viewplaylist";
	}
}

package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.entities.Songs;
import com.example.springboot.repositories.SongsRepository;
@Service
public class SongsServiceImplementation implements SongsService
{
	@Autowired
	SongsRepository songrepo;

	@Override
	public String addSongs(Songs song) 
	{
		songrepo.save(song);
		return "Songs added";
	}

	@Override
	public boolean songExists(String name) 
	{
		Songs song=songrepo.findByName(name);
		if (song==null) 
		{
			//Song is not there 
                return false;
		}
		else
		{
			//Song is present
			return true;
		}

	}

	@Override
	public List<Songs> fetchAllSongs() 
	{
		List<Songs> songslist=songrepo.findAll();
		return songslist;
	}

	@Override
	public void updateSong(Songs song)
	{
		songrepo.save(song);
		
	}

}

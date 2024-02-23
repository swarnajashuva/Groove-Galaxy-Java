package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.entities.PlayList;
import com.example.springboot.entities.Songs;
import com.example.springboot.repositories.PlayListRepository;

@Service
public class PlayListServiceImplementation implements PlayListService
{
	@Autowired
    PlayListRepository prepo;

	@Override
	public String addPlaylist(PlayList playlist) 
	{
		prepo.save(playlist);
        return "";
	}

	@Override
	public List<PlayList> fetchPlaylist() 
	{
        return prepo.findAll();
	}
}

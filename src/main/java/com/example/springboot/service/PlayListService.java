package com.example.springboot.service;

import java.util.List;

import com.example.springboot.entities.PlayList;
import com.example.springboot.entities.Songs;

public interface PlayListService
{

   public String addPlaylist(PlayList playlist);

    public List<PlayList> fetchPlaylist();
    
}

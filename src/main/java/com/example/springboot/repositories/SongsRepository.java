package com.example.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entities.Songs;

public interface SongsRepository extends JpaRepository<Songs, Integer>
{
   public Songs findByName(String name);
}

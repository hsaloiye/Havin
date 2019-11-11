package com.boot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String name;
    public String description;
    public String duration;
    public int minPlayers;
    public int maxPlayers;
    public String genre;

    public Game(long id, String name, String description, String duration, int minPlayers, int maxPlayers, String genre){
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.genre = genre;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setDuration(String duration){
        this.duration = duration;
    }

    public String getDuration(){
        return duration;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public String getGenre(String genre){
        return genre;
    }

    public void setMinPlayers(int minPlayers){
        this.minPlayers = minPlayers;
    }

    public int getMinPlayers(){
        return minPlayers;
    }

    public void setMaxPlayers(int maxPlayers){
        this.maxPlayers = maxPlayers;
    }

    public int getMaxPlayers(){
        return maxPlayers;
    }
}

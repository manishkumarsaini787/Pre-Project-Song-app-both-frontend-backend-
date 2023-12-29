package com.example.SpotifyApplication.services;

import com.example.SpotifyApplication.domain.Song;

import java.util.List;

public interface ISongServices {

    public Song saveSong(Song song);

    public List<Song>getAllSong();





}

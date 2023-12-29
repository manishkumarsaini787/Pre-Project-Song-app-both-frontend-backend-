package com.example.SpotifyApplication.services;

import com.example.SpotifyApplication.domain.Song;
import com.example.SpotifyApplication.repository.ISongsRepository;
import com.example.SpotifyApplication.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongServicesIMPL implements ISongServices{

    ISongsRepository iSongsRepository;
    @Autowired
    public SongServicesIMPL(ISongsRepository iSongsRepository) {
        this.iSongsRepository = iSongsRepository;
    }

    @Override
    public Song saveSong(Song song) {
        return iSongsRepository.save(song);
    }

    @Override
    public List<Song> getAllSong() {
        return iSongsRepository.findAll();
    }
}

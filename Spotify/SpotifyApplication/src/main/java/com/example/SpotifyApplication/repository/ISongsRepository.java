package com.example.SpotifyApplication.repository;

import com.example.SpotifyApplication.domain.Song;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ISongsRepository extends MongoRepository<Song,String> {
}

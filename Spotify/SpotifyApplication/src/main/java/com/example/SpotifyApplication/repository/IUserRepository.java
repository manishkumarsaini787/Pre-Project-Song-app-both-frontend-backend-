package com.example.SpotifyApplication.repository;

import com.example.SpotifyApplication.domain.PlayList;
import com.example.SpotifyApplication.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface IUserRepository extends MongoRepository<User,String> {
//    @Query("")
//    public List<PlayList> findByname(String email);

}

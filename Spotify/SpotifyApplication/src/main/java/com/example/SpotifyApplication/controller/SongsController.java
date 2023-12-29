package com.example.SpotifyApplication.controller;

import com.example.SpotifyApplication.domain.Song;
import com.example.SpotifyApplication.services.ISongServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("song")
public class SongsController {

    ISongServices iSongServices;
@Autowired
    public SongsController(ISongServices iSongServices) {
        this.iSongServices = iSongServices;
    }
//  http://localhost:63300/song/save
    @PostMapping("/save")
    public ResponseEntity saveSong(@RequestBody Song song){

    return new ResponseEntity(iSongServices.saveSong(song), HttpStatus.CREATED);

    }

    //  http://localhost:63300/song/getall
    @GetMapping("/getall")
    public ResponseEntity getSongs(){
    return new ResponseEntity(iSongServices.getAllSong(), HttpStatus.OK);
}



}

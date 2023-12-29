package com.example.SpotifyApplication.controller;

import com.example.SpotifyApplication.domain.PlayList;
import com.example.SpotifyApplication.domain.Song;
import com.example.SpotifyApplication.domain.User;
import com.example.SpotifyApplication.exception.*;
import com.example.SpotifyApplication.services.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("spotify/user")
public class UserController {
    IUserServices  iUserServices;
    @Autowired
    public UserController(IUserServices iUserServices) {
        this.iUserServices = iUserServices;
    }


  //  http://localhost:63300/spotify/user/addUser

    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody User user)throws UserAlreadyException {
            try {
                return new ResponseEntity(iUserServices.saveUser(user), HttpStatus.CREATED);
            } catch (UserAlreadyException exception) {
                throw exception;
            }
    }

    //http://localhost:63300/spotify/user/email
    @GetMapping("/{email}")
    public ResponseEntity getUser(@PathVariable String email){
        return  new ResponseEntity<>(iUserServices.getUser(email),HttpStatus.OK)    ;
    }

    //  http://localhost:63300/spotify/user/playlist
    @GetMapping("/playlist")
    public ResponseEntity getPlaylist(HttpServletRequest httpServletRequest){
        String email=(String) httpServletRequest.getAttribute("attr1");
        return  new ResponseEntity<>(iUserServices.getPlaylist(email),HttpStatus.OK)    ;
    }

    @PostMapping("/createplaylist/{email}")
    public ResponseEntity createPlaylist(@RequestBody PlayList playList, @PathVariable String email)throws SongAlreadyException {
        return new ResponseEntity<>(iUserServices.createPlaylist(playList,email),HttpStatus.OK);
    }


    //  http://localhost:63300/spotify/user/addToPlaylist/{email}/{playlistname}

    @PostMapping("/addToPlaylist/{email}/{playlistname}")
    public ResponseEntity addSongToPlaylist(@RequestBody Song song,@PathVariable String email,@PathVariable String playlistname)throws SongAlreadyException {
        return new ResponseEntity<>(iUserServices.addSongToPlayist(email,song,playlistname),HttpStatus.OK);
    }

    @GetMapping("/viwSonginplaylist/{email}/{playlistname}")
    public ResponseEntity viewSongsInPlaylist(@PathVariable String email,@PathVariable String playlistname) {
        return new ResponseEntity<>(iUserServices.viewSonsginPlaylist(email,playlistname),HttpStatus.OK);
    }


}

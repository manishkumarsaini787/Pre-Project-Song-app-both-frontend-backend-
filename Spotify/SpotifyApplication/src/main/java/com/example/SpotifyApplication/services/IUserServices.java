package com.example.SpotifyApplication.services;

import com.example.SpotifyApplication.domain.PlayList;
import com.example.SpotifyApplication.domain.Song;
import com.example.SpotifyApplication.domain.User;
import com.example.SpotifyApplication.exception.*;

import java.util.List;

public interface IUserServices {

    public User saveUser(User user)throws UserAlreadyException;
    public User getUser(String email);

    public List<PlayList> getPlaylist(String email);
    public  User createPlaylist(PlayList playlist,String email);

    public User addSongToPlayist(String email,Song song,String playlistname)throws SongAlreadyException;
    public List<Song> viewSonsginPlaylist(String email,String playlistname);
    public User deleteplaylist(String email,String playlistname) throws UserNotFoundException,PlayListNotFoundException;
}

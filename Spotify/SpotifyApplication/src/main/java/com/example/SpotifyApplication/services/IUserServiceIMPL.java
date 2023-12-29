package com.example.SpotifyApplication.services;

import com.example.SpotifyApplication.domain.PlayList;
import com.example.SpotifyApplication.domain.Song;
import com.example.SpotifyApplication.domain.User;
import com.example.SpotifyApplication.exception.*;
import com.example.SpotifyApplication.proxy.UserProxy;
import com.example.SpotifyApplication.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service
public class IUserServiceIMPL implements IUserServices{

    IUserRepository iUserRepository;
    UserProxy userProxy;
    @Autowired
    public IUserServiceIMPL(IUserRepository iUserRepository, UserProxy userProxy) {
        this.iUserRepository = iUserRepository;
        this.userProxy = userProxy;
    }

    @Override
    public User saveUser(User user) throws UserAlreadyException{
        if(iUserRepository.findById(user.getEmail()).isEmpty()) {
            userProxy.registerUser(user);
            return iUserRepository.save(user);

        }
       throw new UserAlreadyException();
    }
    @Override
    public User getUser(String email) {
        return iUserRepository.findById(email).get();
    }
    @Override
    public List<PlayList> getPlaylist(String email) {
        User use=iUserRepository.findById(email).get();
        return use.getPlaylist();
    }

    @Override
    public User createPlaylist(PlayList playList,String email) {
        User user=iUserRepository.findById(email).get();
        List<PlayList> playLists= user.getPlaylist();
        playLists.add(playList);
        user.setPlaylist(playLists);
        return iUserRepository.save(user);
    }

    @Override
    public User addSongToPlayist(String email, Song song,String playlistname) throws SongAlreadyException{
        User user=iUserRepository.findById(email).get();
        List<PlayList> playLists= user.getPlaylist();
        PlayList playList;
        Iterator<PlayList> iterator=playLists.iterator();
        List<Song> songs;
        Song song1;
        Iterator<Song> iteratorsong;
        while(iterator.hasNext()){
            playList=iterator.next();
            if (playList.getName().equals(playlistname)){
                songs=playList.getSongs();

                iteratorsong=songs.iterator();
                while (iteratorsong.hasNext()){
                    song1=iteratorsong.next();
                    if(song1.getName().equals(song.getName())){
                        throw new SongAlreadyException();
                    }

                }
                songs.add(song);
            }

        }

        return iUserRepository.save(user);
    }

    @Override
    public List<Song> viewSonsginPlaylist(String email, String playlistname) {
        User user=iUserRepository.findById(email).get();
        List<PlayList> playLists= user.getPlaylist();
        PlayList playList;
        Iterator<PlayList> iterator=playLists.iterator();
        List<Song> songs=new ArrayList<>();

        while(iterator.hasNext()){
            playList=iterator.next();
            if (playList.getName().equals(playlistname)){
                songs=playList.getSongs();
            }
        }
        return songs;
    }

    @Override
    public User deleteplaylist(String email, String playlistname) throws UserNotFoundException, PlayListNotFoundException {
        boolean isPlaylistPresent;
        if (iUserRepository.findById(email).isEmpty()) {
            throw new UserNotFoundException();
        }
        User fetchedUser = iUserRepository.findById(email).get();
        List<PlayList> userPlaylist = fetchedUser.getPlaylist();
        isPlaylistPresent= userPlaylist .removeIf(list -> list.getName().equals(playlistname));
        if (!isPlaylistPresent) {
            throw new PlayListNotFoundException();
        }
        fetchedUser.setPlaylist(userPlaylist);
        return iUserRepository.save(fetchedUser);
    }



}




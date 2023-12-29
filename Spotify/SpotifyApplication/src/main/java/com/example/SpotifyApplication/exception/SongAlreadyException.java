package com.example.SpotifyApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT,reason = "this song is already exist in Playlist")
public class SongAlreadyException extends Exception{
}

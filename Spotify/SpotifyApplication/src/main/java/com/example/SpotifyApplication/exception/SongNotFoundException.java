package com.example.SpotifyApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT,reason = "this song is not found")

public class SongNotFoundException extends Throwable {
}

package com.example.SpotifyApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT,reason = "this playlist not found")

public class PlayListNotFoundException extends Exception{
}

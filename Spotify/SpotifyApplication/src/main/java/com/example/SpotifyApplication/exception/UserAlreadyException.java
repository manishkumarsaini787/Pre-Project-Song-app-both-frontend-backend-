package com.example.SpotifyApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT,reason = "this user is already account")
public class UserAlreadyException extends Exception{


}

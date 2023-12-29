package com.example.auth.AuthenticationApplication.service;

import com.example.auth.AuthenticationApplication.domain.User;

import java.util.Map;

public interface SecurityToken {
    public Map<String,String> generateToken(User user);
}

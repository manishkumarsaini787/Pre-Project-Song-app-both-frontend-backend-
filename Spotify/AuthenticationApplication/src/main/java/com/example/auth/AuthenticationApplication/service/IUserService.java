package com.example.auth.AuthenticationApplication.service;

import com.example.auth.AuthenticationApplication.domain.User;

public interface IUserService {
    public User registeredUser(User user);
    public User checkLogin(User use);

}

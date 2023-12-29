package com.example.auth.AuthenticationApplication.service;

import com.example.auth.AuthenticationApplication.domain.User;
import com.example.auth.AuthenticationApplication.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository iUserRepository;
    @Override
    public User registeredUser(User user) {
        return iUserRepository.save(user);
    }

    @Override
    public User checkLogin(User use) {
        return iUserRepository.findByEmailAndPassword(use.getEmail(),use.getPassword());
    }
}

package com.example.auth.AuthenticationApplication.controller;

import com.example.auth.AuthenticationApplication.domain.User;
import com.example.auth.AuthenticationApplication.service.SecurityTokenIMPL;
import com.example.auth.AuthenticationApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {

    private UserService userService;
    private SecurityTokenIMPL securityTokenIMPL;
    @Autowired
    public UserController(UserService userService, SecurityTokenIMPL securityTokenIMPL) {
        this.userService = userService;
        this.securityTokenIMPL = securityTokenIMPL;
    }

    //  http://localhost:1829/user/register

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody User user){
        return new ResponseEntity(userService.registeredUser(user), HttpStatus.CREATED);
    }
    //  http://localhost:1829/user/login
    @PostMapping("/login")
    public ResponseEntity LoginUser(@RequestBody User user){
        User reterived=userService.checkLogin(user);
        if (reterived!=null){
            return new ResponseEntity(securityTokenIMPL.generateToken(user),HttpStatus.OK);
        }else
            return new ResponseEntity<>("Authentication Failed.......",HttpStatus.EXPECTATION_FAILED);
    }
}

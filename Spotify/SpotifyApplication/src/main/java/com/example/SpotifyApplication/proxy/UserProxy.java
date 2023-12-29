package com.example.SpotifyApplication.proxy;


import com.example.SpotifyApplication.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// http://localhost:1829/user/register

//    http://localhost:4442/api/User/v1/register  [post] json
@FeignClient(name ="Autentication",url = "http://localhost:1829")
public interface UserProxy {
    @PostMapping("/user/register")
    public ResponseEntity<?> registerUser(@RequestBody User user);
}




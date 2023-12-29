package com.example.auth.AuthenticationApplication.service;

import com.example.auth.AuthenticationApplication.domain.User;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenIMPL implements SecurityToken {


    @Override
    public Map<String, String> generateToken(User user) {


        Map<String, String> result = new HashMap<>();

        Map<String, Object> userdata = new HashMap<>();
        userdata.put("userEmail", user.getEmail());


        String myToken = Jwts.builder()
                .setClaims(userdata)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, "secretKeyForWave46")
                .compact();
        result.put("Token", myToken);
        result.put("Message", "user LoggedIn Successfully......");
        return result;
    }
}

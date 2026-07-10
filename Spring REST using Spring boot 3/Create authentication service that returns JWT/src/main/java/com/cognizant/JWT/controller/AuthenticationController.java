package com.cognizant.JWT.controller;

import com.cognizant.JWT.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public AuthenticationResponse authenticate(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {

        String username = getUser(authorizationHeader);

        String token = jwtUtil.generateToken(username);

        return new AuthenticationResponse(token);
    }

    private String getUser(String authorizationHeader) {

        String encoded = authorizationHeader.substring(6);

        byte[] decoded = Base64.getDecoder().decode(encoded);

        String credentials =
                new String(decoded, StandardCharsets.UTF_8);

        return credentials.split(":")[0];
    }
}
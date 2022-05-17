package com.niit.authenticationservice.service;

import com.niit.authenticationservice.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtSecurityTokenGeneratorImpl implements SecurityTokenGenerator  {



  @Override
  public Map<String, String> generateToken(User user) {
    //a map is an interface that is used to store key-value pair and key should be immutable
    String jwtToken = null;

    //jwts is a class present in maven web token package(dependency) supplying the data to create the web token based on hs256 algorithm
    //method chain is present here where we are actually
    jwtToken = Jwts.builder().setSubject(user.getUsername()).setIssuedAt(new Date())
      .signWith(SignatureAlgorithm.HS256,"secretkey").compact();

    Map<String,String> map = new HashMap<>();
    map.put("token",jwtToken);

    map.put("message", "User Successfully logged in");
    System.out.println(jwtToken);
    return map;
  }
}

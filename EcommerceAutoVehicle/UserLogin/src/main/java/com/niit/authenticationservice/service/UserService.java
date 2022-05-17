package com.niit.authenticationservice.service;

import com.niit.authenticationservice.domain.User;
import com.niit.authenticationservice.exception.UserAlreadyPresentException;
import com.niit.authenticationservice.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

  public User saveUser(User user) throws UserAlreadyPresentException;
  public User findByUsernameAndPassword(String username , String password) throws UserNotFoundException;
  List<User> getAllUsers();

}

package com.niit.authenticationservice.service;


import com.niit.authenticationservice.domain.User;
import com.niit.authenticationservice.exception.UserAlreadyPresentException;
import com.niit.authenticationservice.exception.UserNotFoundException;
import com.niit.authenticationservice.repository.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    //we are using the autowired annotations here which means that this object is going to be present in the IOC container
    //automatically during the process of compilation
    @Autowired
  public UserServiceImpl(UserRepository userRepository){
    this.userRepository = userRepository;
    }


  @Override
  public User saveUser(User user) throws UserAlreadyPresentException {
        if(userRepository.findById(user.getUsername()).isPresent())
        {
            throw new UserAlreadyPresentException();
        }
        return userRepository.save(user);
    }

  @Override
  public User findByUsernameAndPassword(String username , String password) throws UserNotFoundException {
         User user =  userRepository.findByUsernameAndPassword(username , password);
         if(user == null){
           throw new UserNotFoundException();
         }
         return user;

  }

    @Override
    public List<User> getAllUsers() {
      return userRepository.findAll();
    }

}

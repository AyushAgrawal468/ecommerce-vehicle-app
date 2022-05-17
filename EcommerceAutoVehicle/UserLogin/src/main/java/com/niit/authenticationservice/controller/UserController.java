package com.niit.authenticationservice.controller;


import com.niit.authenticationservice.exception.UserAlreadyPresentException;
import com.niit.authenticationservice.service.UserService;
import com.niit.authenticationservice.domain.User;
import com.niit.authenticationservice.exception.UserNotFoundException;
import com.niit.authenticationservice.service.SecurityTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//as we are using the restfull api, so the should be of type REST
@RestController
//we have CORS policies which prevents one to access the service being used by other than its same domain/server.
//to bypass that we are using this annotation
@CrossOrigin
public class UserController {

    private ResponseEntity responseEntity;
    private UserService userService;
    private SecurityTokenGenerator securityTokenGenerator;


    @Autowired
    public UserController(UserService userService, SecurityTokenGenerator securityTokenGenerator) {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }


    //Should only give username and password
    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody User user) throws UserNotFoundException {

        Map<String, String> map = new HashMap<>();
        try {
            User userObj = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
           if(userObj.getType().equals("admin"))
           {
               map = securityTokenGenerator.generateToken(user);
           }
            responseEntity = new ResponseEntity(map, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException();
        } catch (Exception e) {
            responseEntity = new ResponseEntity("Try after sometime!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    // first step - register the user
    @PostMapping("/register")
    public ResponseEntity saveUser(@RequestBody User user) throws UserAlreadyPresentException {
        try {
            User createdUser = userService.saveUser(user);
            return responseEntity = new ResponseEntity("User Created", HttpStatus.CREATED);
        } catch (UserAlreadyPresentException uap) {
            throw new UserAlreadyPresentException();
        } catch (Exception e) {
            responseEntity = new ResponseEntity("Try after sometime!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("/api/v1/userservice/users")
    public ResponseEntity getAllUsers(HttpServletRequest request) {

        System.out.println("aywdgvjwavhjhbwjh");
        List<User> list = userService.getAllUsers();
        responseEntity = new ResponseEntity(list, HttpStatus.OK);
        return responseEntity;

    }


}

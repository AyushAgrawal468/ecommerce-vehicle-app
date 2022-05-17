package com.niit.authenticationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Here we are setting the response status of this class as it extends the Exception class which have all the exceptions.
@ResponseStatus(code = HttpStatus.CONFLICT,reason = "User Already Present")
public class UserAlreadyPresentException extends Exception{
}

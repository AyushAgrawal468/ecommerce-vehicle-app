package com.niit.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Vehicle Not Found With Specific Id")
public class VehicleNotFoundException extends Exception{
}

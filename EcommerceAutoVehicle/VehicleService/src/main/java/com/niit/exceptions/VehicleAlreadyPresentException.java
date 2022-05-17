package com.niit.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Vehicle Details Already Present")
public class VehicleAlreadyPresentException extends Exception{
}

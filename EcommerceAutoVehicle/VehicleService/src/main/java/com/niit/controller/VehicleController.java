package com.niit.controller;

import com.niit.domain.Vehicle;
import com.niit.exceptions.VehicleAlreadyPresentException;
import com.niit.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class VehicleController {

   private ResponseEntity responseEntity;
   private VehicleService vehicleService;

   public VehicleController(VehicleService vehicleService) {
      this.vehicleService = vehicleService;
   }
   @PostMapping("/vehicle")
   public ResponseEntity<?> saveVehicle(@RequestBody Vehicle vehicle) throws VehicleAlreadyPresentException
   {
      try{
         vehicleService.saveVehicleDetails(vehicle);
         responseEntity=new ResponseEntity(vehicle, HttpStatus.CREATED);
      }catch (VehicleAlreadyPresentException vap)
      {
         throw new VehicleAlreadyPresentException();
      }catch (Exception ex)
      {
         responseEntity = new ResponseEntity("Error!! try Again Later",HttpStatus.INTERNAL_SERVER_ERROR);
      }
      return responseEntity;
   }

   @GetMapping("/vehicles")
   public ResponseEntity<?> getAllVehicles() throws Exception
   {
      try{
         responseEntity = new ResponseEntity(vehicleService.getAllVehicleDetails(),HttpStatus.OK);
      }catch (Exception ex)
      {
         responseEntity = new ResponseEntity("Error!! try Again Later",HttpStatus.INTERNAL_SERVER_ERROR);

      }
      return responseEntity;
   }

}

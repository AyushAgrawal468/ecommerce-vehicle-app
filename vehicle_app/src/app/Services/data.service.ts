import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
// import { retry } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {


  adminOrUser:any="";
  userNameLoggedIn:any;
  vehicleDetailsOnClick:any;
  httpOptions:any={
    headers:""
  }

  //declaring as the parametre so that it get available the moment we call this service
  constructor(private httpClient: HttpClient) { }

  //method to send data to the Microservice where the data is stored in MySQL DB
  registerUser(data: any) {
    this.httpClient.post("http://localhost:8085/register", data).subscribe(data => {
      console.log(data);

    },
      error => {
        console.log(error);
        if (error.status == 201) {
          alert("Registered Successfully")
        }
        else
          alert("Error!!!!! Try Again")
      })
  }

  loginUserAndAdmin(data: any) {
    return this.httpClient.post("http://localhost:8085/login", data);
  }

  getAllUsers()
  {
    return this.httpClient.get("http://localhost:8085//api/v1/userservice/users",this.httpOptions);
  }

  getAllVehicles()
  {
    return this.httpClient.get("http://localhost:8083/api/v1/vehicles");
  }

  saveVehicle(vehicleData:any)
  {
    this.httpClient.post("http://localhost:8083/api/v1/vehicle",vehicleData).subscribe(data=>{
      console.log(data);
      
      alert("Data Saved Successfully");
    },
    error=>{
      console.log(error);
      
      alert("Data Can't Be Saved!!! Invalid Data ")
    })
  }

  saveCart(data:any)
  {
    this.httpClient.post("http://localhost:8083/cart",data).subscribe(data=>{
      // console.log(data);
      alert("Vehicle Added to Cart")
      
    },
    error=>{
      console.log(error);
      alert("Vehicle Can't Be Added to Cart")
      
    })
  }

  getCartByUserName(username:String)
  {
    return this.httpClient.get(`http://localhost:8083/cart/${username}`);
  }

  deleteCartById(id:String)
  {
    this.httpClient.delete(`http://localhost:8083/cart/delete/${id}`).subscribe(data=>{},
    error=>{
      console.log(error);
      if(error.status==200)
      alert("Data Removed From The Cart Successfully")
      else
      alert("Invalid Data!!!! Try Again");
    })
  }
}

import { Component, OnInit } from '@angular/core';
import { DataService } from '../Services/data.service';
import { vehicleCartFormat } from '../vehicleCartFormat';

@Component({
  selector: 'app-user-interface',
  templateUrl: './user-interface.component.html',
  styleUrls: ['./user-interface.component.css']
})
export class UserInterfaceComponent implements OnInit {

  vehiclesInCart:any={};

  vehicleDetails:any={};
  vehiclesCart:vehicleCartFormat={
    cartId:"",
    username: "",
    vehicle: {
      vehicleId: '',
      vehicleType: '',
      vehicleModel: '',
      vehicleManufDate: ''
    }
  }


  constructor(private dataService:DataService) {
    this.dataService.getAllVehicles().subscribe(data=>{
    console.log(data);
    this.vehicleDetails=data;    
    })
    
   }

  ngOnInit(): void {
    console.log(this.dataService.userNameLoggedIn);
    this.dataService.getCartByUserName(this.dataService.userNameLoggedIn).subscribe(data=>{
      console.log(data);  
      this.vehiclesInCart=data;    
    },
    error=>{
      console.log(error);
    })
  }
  
  addToCart(data:any)
  {
    console.log(data);
    
    this.vehiclesCart.username=this.dataService.userNameLoggedIn;
    this.vehiclesCart.vehicle = data;

    console.log(this.vehiclesCart);
    
    this.dataService.saveCart(this.vehiclesCart);
    this.ngOnInit();
    this.ngOnInit();
    
  }

  deleteItemFromCart(cartId:any)
  {
    console.log(cartId);
    this.dataService.deleteCartById(cartId);
    this.ngOnInit();
    this.ngOnInit();

  }
}

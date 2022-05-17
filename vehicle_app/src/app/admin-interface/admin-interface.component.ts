import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { DataService } from '../Services/data.service';
import { vehicleFormat } from '../vehicleFormat';

@Component({
  selector: 'app-admin-interface',
  templateUrl: './admin-interface.component.html',
  styleUrls: ['./admin-interface.component.css']
})
export class AdminInterfaceComponent implements OnInit {

  vehicleDetails:any={};

  constructor(private dataService: DataService) {
    
   this.ngOnInit();
  }

  vehicleForm!: FormGroup;

  ngOnInit() {
    this.dataService.getAllVehicles().subscribe(data=>{
      console.log(data);
      this.vehicleDetails = data;
    });
    this.vehicleForm = new FormGroup({
      vehicleId: new FormControl(this.vehicle.vehicleId, Validators.required),
      vehicleType: new FormControl(this.vehicle.vehicleType),
      vehicleModel: new FormControl(this.vehicle.vehicleModel),
      vehicleManufDate: new FormControl(this.vehicle.vehicleManufDate)

    });


  }
  vehicles: any;

  vehicle: vehicleFormat = {
    vehicleId: "",
    vehicleType: "",
    vehicleModel: "",
    vehicleManufDate: ""
  }

  get vehicleId() { return this.vehicleForm.controls['vehicleId'] }
  get vehicleType() { return this.vehicleForm.controls['vehicleType'] }
  get vehicleModel() { return this.vehicleForm.controls['vehicleModel'] }
  get vehicleManufDate() { return this.vehicleForm.controls['vehicleManufDate'] }


  submitForm() {
    this.vehicle.vehicleId = this.vehicleId.value;
    this.vehicle.vehicleType = this.vehicleType.value;
    this.vehicle.vehicleModel = this.vehicleModel.value;
    this.vehicle.vehicleManufDate = this.vehicleManufDate.value;
    console.log(this.vehicle);
   
    this.dataService.saveVehicle(this.vehicle);
    this.ngOnInit();
    this.ngOnInit();
  }
  transferData(data:any)
  {
    console.log(data);
    this.vehicle=data;
    this.ngOnInit();
    this.ngOnInit();
  }
  clearScreen()
  {
    this.vehicle.vehicleId='';
    this.vehicle.vehicleManufDate='';
    this.vehicle.vehicleModel='';
    this.vehicle.vehicleType='';
    this.ngOnInit();
    this.ngOnInit();
  }

  getUsers()
  {
    this.dataService.getAllUsers().subscribe(data=>{
      console.log(data);
    },
    error=>{
      console.log(error);
      
    })
  }

}

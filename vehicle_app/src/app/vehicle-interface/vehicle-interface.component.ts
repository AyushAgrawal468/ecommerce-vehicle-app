import { Component } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { DataService } from '../Services/data.service';

@Component({
  selector: 'app-vehicle-interface',
  templateUrl: './vehicle-interface.component.html',
  styleUrls: ['./vehicle-interface.component.css']
})
export class VehicleInterfaceComponent {

  data:any={};

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(private breakpointObserver: BreakpointObserver,private dataService:DataService) {
    this.dataService.getAllVehicles().subscribe(data=>{
      console.log(data);
      this.data = data;
    })
  }

  adminOrUser:any=this.dataService.adminOrUser;

  transferData(data:any)
  {
    console.log(data);
    this.dataService.vehicleDetailsOnClick=data;
  }

}

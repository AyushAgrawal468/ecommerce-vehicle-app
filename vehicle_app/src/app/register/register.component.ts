import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../Services/data.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  //creating a property where i m going to store the data inserted in the form
  formData: any = {};
  registerData={
    username:"",
    password:"",
    type:""
  }

  constructor(private dataService: DataService,private router:Router) { }


  ngOnInit(): void {
  }

  register() {
    console.log(this.formData);
    this.registerData.username=this.formData.username;
    this.registerData.password=this.formData.password;
    this.registerData.type="user";
    if (this.formData.password == this.formData.confirmPassword) {
      this.dataService.registerUser(this.registerData);
      this.router.navigate(['home/login']);
    }
    else
      alert("Passwords Not Matching!!!! Try Again.");
  }

}

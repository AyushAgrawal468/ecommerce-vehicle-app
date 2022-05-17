import { HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { observable, Observable } from 'rxjs';
import { DataService } from '../Services/data.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  formData: any = {
    username: "",
    password: ""
  };
  response: any = {
    message: "",
    token: ""
  }

  constructor(private dataService: DataService, private router: Router) { }

  ngOnInit(): void {
  }
  login() {
    console.log(this.formData);
    //using the observable 
    this.dataService.loginUserAndAdmin(this.formData).subscribe(data => {
      console.log(data);
      this.response = data;
      var header = new HttpHeaders().set("Authorization", "Bearer " + this.response.token);
      this.dataService.httpOptions.headers = header;
      if (this.response.token != null) {
        console.log("admin");
        this.dataService.adminOrUser = "admin";
        this.dataService.userNameLoggedIn = this.formData.username;
        this.router.navigate(["vehicles/admin"])

      }
      else {
        console.log("User");
        this.dataService.adminOrUser = "user";
        this.dataService.userNameLoggedIn = this.formData.username;
        this.router.navigate(["vehicles/user"])

      }

    },
      error => {
        console.log(error);
        alert("Invalid Password Or E-mail")
      })
  }

}

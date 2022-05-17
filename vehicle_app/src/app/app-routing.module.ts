import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminInterfaceComponent } from './admin-interface/admin-interface.component';
import { FirstPageComponent } from './first-page/first-page.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { UserInterfaceComponent } from './user-interface/user-interface.component';
import { VehicleInterfaceComponent } from './vehicle-interface/vehicle-interface.component';

const routes: Routes = [
  {
    path: "home",
    component: FirstPageComponent,
    children: [
      {
        path: "register",
        component: RegisterComponent
      },
      {
        path: "login",
        component: LoginComponent
      },
      {
        path: "",
        redirectTo: "login",
        pathMatch: "full"
      }
    ]
  },
  {
    path: "",
    redirectTo: "home",
    pathMatch: "full"
  },
  {
    path: "vehicles",
    component: VehicleInterfaceComponent,
    children:[
      {
        path:"admin",
        component:AdminInterfaceComponent
      },
      {
        path:"user",
        component:UserInterfaceComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { PostEmployeeComponent } from './component/post-employee/post-employee.component';

import { LoginComponent } from './component/login/login.component';

const routes: Routes = [

  {
    path:'employees',
    component:LoginComponent
  },
  {
    path:'home',
    component:LoginComponent
  },
  {
    path:'postdata',
    component:LoginComponent
  },
  {
    path:'auth',
    component:LoginComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

  
 }

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { PostEmployeeComponent } from './component/post-employee/post-employee.component';

const routes: Routes = [

  {
    path:'employees',
    component:PostEmployeeComponent
  },
  {
    path:'home',
    component:PostEmployeeComponent
  },
  {
    path:'postdata',
    component:PostEmployeeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

  
 }

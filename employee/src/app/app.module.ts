import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { HttpClientModule} from '@angular/common/http';
import { PostEmployeeComponent } from './component/post-employee/post-employee.component';
import { PostServiceService } from './service/post-service.service';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './component/login/login.component';
import { LoginService } from './service/authenticate/login.service';
import { HeaderComponent } from './component/header/header.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeListComponent,
    PostEmployeeComponent,
    LoginComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  
    
  ],
  providers: [PostServiceService,LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { 

  
}

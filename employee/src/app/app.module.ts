import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { HttpClientModule} from '@angular/common/http';
import { PostEmployeeComponent } from './component/post-employee/post-employee.component';
import { PostServiceService } from './service/post-service.service';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeListComponent,
    PostEmployeeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    
  ],
  providers: [PostServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { 

  
}

import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/service/authenticate/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent  implements OnInit{

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
  constructor(private loginService: LoginService) {

  }
  formData: any = {};
  loginUser(){
    alert("register");
    console.log("FORM DATA IS :",this.formData);

    this.loginService.authenticateUser(this.formData).subscribe(
      response => {
        console.log('Registration successful:', response);
        localStorage.setItem('token', response.accessToken);
      
      },
      error => {
        console.error('Registration failed:', error);
     
      }
    );
  }


  
}

import { Component,  OnInit } from '@angular/core';
import { PostServiceService } from '../../service/post-service.service'


@Component({
  selector: 'app-post-employee',
  templateUrl: './post-employee.component.html',
  styleUrls: ['./post-employee.component.scss']
})
export class PostEmployeeComponent implements OnInit{
constructor(private PostServiceService: PostServiceService) {

  }
  ngOnInit(): void {
    console.log("Call Post Service  .. ");
  // this.postData();
  }
   res: any;
   formData: any = {};
   showDiv:boolean=false;
  handleClick(){
  //this.postData();
  }

 

  registerUser() {
    alert("register");
    console.log("FORM DATA IS :",this.formData);

    this.PostServiceService.postApi(this.formData).subscribe(
      response => {
        console.log('Registration successful:', response);
        // Optionally, redirect the user to another page or display a success message
      },
      error => {
        console.error('Registration failed:', error);
        // Optionally, display an error message to the user
      }
    );
  }
  postData() {
    console.log("FORM DATA IS :",this.formData);
    var data = { username:'test',email:'test@gmail.com',password:'test@123',role:['ROLE_USER'] }; // Replace with your data
    this.PostServiceService.postApi(data).subscribe((response: any)=> {
      alert(response);
      this.res=response.message;
      this.showDiv=true;

      console.log('Response:', this.res);
    }, (error: any) => { // Explicitly define the type of error parameter
      this.res=error.message;
      console.log('Response:', this.res);
      this.showDiv=true;

    });
  }
}

import { Component, OnInit } from '@angular/core';
import { PostServiceService } from '../../service/post-service.service'

@Component({
  selector: 'app-post-employee',
  templateUrl: './post-employee.component.html',
  styleUrls: ['./post-employee.component.scss']
})
export class PostEmployeeComponent{
  constructor(private PostServiceService: PostServiceService) {}
  // ngOnInit(): void {
  //   console.log("Call Post Service  .. ");
  //  //this.postData();
  // }

  onSubmit() {
    console.log("Clicked Button .. ");
  }
  postData() {
    var data = { username:'satyam',email:'satyam@gmail.com',password:'satyam@123',role:['ROLE_USER'] }; // Replace with your data
    this.PostServiceService.postApi(data).subscribe((response: any)=> {
      console.log('Response:', response);
    }, (error: any) => { // Explicitly define the type of error parameter
      console.error('Error:', error);
    });
  }
}

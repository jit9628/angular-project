import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl="http://localhost:8080/api/v1/employees";
  constructor(private httpClient:HttpClient) { }

getEmployeeList(): Observable<Employee[]>{
  console.log("Call Api .. ");

 var data= this.httpClient.get('http://localhost:8080/api/v1/employees');
  return this.httpClient.get<Employee[]> ('http://localhost:8080/api/v1/employees');

}

}



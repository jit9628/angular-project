import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PostServiceService {
  constructor(private httpClient: HttpClient) { }




  postApi(data: any): Observable<any> {
    console.log("Hit Post Service ..");
    
    return this.httpClient.post<any>(`http://localhost:8522/api/auth/signup`, data);
  }

}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpClient: HttpClient) { }

  Base_Url="http://localhost:8522/api/auth/";
  authenticateUser(formData: any){
    return this.httpClient.post<any>(this.Base_Url+"signin",formData);
  }
}

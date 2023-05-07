import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
//import { Injectable } from '@angular/core';
import baseUrl from './helper';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  //constructor() { }

  constructor(private http: HttpClient) {}

  //add user

  public addUser(user: any) {
    return this.http.post(`${baseUrl}/user/`, user);
  }
}

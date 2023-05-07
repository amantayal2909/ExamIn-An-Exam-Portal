import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';



@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit{
   
  user =null;

  // constructor(public login : LoginService) {}

  // ngOnInit(): void {
  //   this.user = this.login.getUser();
  //   this.login.getCurrentUser().subscribe(
  //     (user: any) => {
  //       this.user = user;
  //     },
  //     (error) => {
  //       alert('error');
  //     }
  //   );
  // }
  constructor(public login: LoginService) {}

  ngOnInit(): void {
    //this.isLoggedIn = this.login.isLoggedIn();
    this.user = this.login.getUser();
    this.login.loginStatusSubject.asObservable().subscribe((data) => {
      //this.isLoggedIn = this.login.isLoggedIn();
      this.user = this.login.getUser();
    });
  }
}

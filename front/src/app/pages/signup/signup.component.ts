import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  
  constructor(private userService: UserService, private snack: MatSnackBar) {}

  

  ngOnInit(): void {}

  public user = {
    username: '',
    password: '',
    firstname: '',
    lastname: '',
    email: '',
    phone: '',
  };

  formSubmit() {
    console.log(this.user);
    //alert('Submit');
    
    if (this.user.username == '' || this.user.username == null) {
      // alert('User is required !!');
      
      this.snack.open('Username is required !! ', '', {
        duration: 3000,
      });
      return;
    }

    if (this.user.password == '' || this.user.password == null) {
      // alert('User is required !!');
      this.snack.open('Password is required !! ', '', {
        duration: 3000,
      });
      return;
    }

    //validate

    //addUser: userservice
    
      
    this.userService.addUser(this.user).subscribe(
      (data: any) => {
        //success
        console.log(data);
        //alert('success');
        Swal.fire('Successfully done !!', 'User id is ' + data.id, 'success');
        this.user = {
          username: '',
          password: '',
          firstname: '',
          lastname: '',
          email: '',
          phone: '',
        };
      },
      (error) => {
        //error
        console.log(error);
         //alert('something went wrong');
        this.snack.open(error.error.text, '', {
         duration: 3000,
        });
      }
    );
    
  }
}

import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private authService: AuthService, private router: Router) { }

  username: string = "";
  password: string = "";

  ngOnInit(): void {
  }

  onLogin(): void {
    this.authService.login({
      username: this.username,
      password: this.password
    }).subscribe(response => {
      if (response.token == null) {
        console.log("Invalid credentials!");
      } else {
        console.log("Successfully logged in.");
        localStorage.setItem("token", response.token);
        this.router.navigate([""]);
      }
    }, error => {
      console.log("Authentication service is not available, please try again later!");
    });
  }

}

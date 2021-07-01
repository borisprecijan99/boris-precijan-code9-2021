import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "../../shared/model/user";
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User = new User();

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
  }

  onRegister(): void {
    this.authService.register(this.user).subscribe(response => {
      if (response == true) {
        console.log("You have successfully registered.");
        this.router.navigate(["login"]);
      } else {
        console.log("Username already exists.");
      }}, error => {
        console.log("Authentication service is not available, please try again later.");
      });
  }

}

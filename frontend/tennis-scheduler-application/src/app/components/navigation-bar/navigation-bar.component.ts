import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-navigation-bar',
  templateUrl: './navigation-bar.component.html',
  styleUrls: ['./navigation-bar.component.css']
})
export class NavigationBarComponent implements OnInit {

  constructor(private authService: AuthService, private  router: Router) { }

  ngOnInit(): void {
  }

  isLoggedIn(): boolean {
    if (localStorage.getItem("token")) {
      return true;
    }
    return false;
  }

  logout(): boolean {
    this.authService.logout().subscribe(response => {
      localStorage.clear();
    })
    this.router.navigate(["login"]);
    return true;
  }

}

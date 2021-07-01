import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private httpClient: HttpClient) { }

  ngOnInit(): void {
  }

  onLogin(form) {
    this.httpClient.get("http://localhost:8081/api/tennis_players/getAll").subscribe(resp => {
      console.log(resp);
    });
    /*this.httpClient.post("http://localhost:8085/api/users/login", form.value).subscribe((resp: any) => {
      localStorage.setItem("token", resp.token);
    }/*, error => {
      console.log(error);
      console.log("Auth-service is not available! Try again later...");
    });*/
  }

}

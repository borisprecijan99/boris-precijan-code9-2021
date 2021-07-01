import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private httpClient: HttpClient) { }

  ngOnInit(): void {
  }

  onRegister(form) {
    this.httpClient.post("http://localhost:8085/api/users/register", form.value).subscribe(resp => {
      if (resp == true) {
        console.log("Uspesno ste se registrovali! Cestitamo :D");
      } else {
        console.log("Zao nam je... Pokusajte ponovo.");
      }
    });
  }

}

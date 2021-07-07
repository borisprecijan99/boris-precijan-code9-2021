import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {User} from "../shared/model/user";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private BACKEND_BASE: string = "http://localhost:8085/api/users"

  constructor(private httpClient: HttpClient) { }

  login(credentials: any): Observable<any> {
    return this.httpClient.post(this.BACKEND_BASE + "/login", {
      username: credentials.username,
      password: credentials.password
    });
  }

  register(user: User): Observable<boolean> {
    return this.httpClient.post<boolean>(this.BACKEND_BASE + "/register", user);
  }

  logout(): Observable<boolean> {
    return this.httpClient.get<boolean>(this.BACKEND_BASE + "/logout");
  }

}

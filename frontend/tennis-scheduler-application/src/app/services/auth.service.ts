import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private BACKEND_BASE: string = "http://localhost:8085/api/users"

  constructor(private httpClient: HttpClient) { }

  public login(credentials): Observable<any> {
    return null;
  }

  public register(): Observable<boolean> {
    return null;
  }

}

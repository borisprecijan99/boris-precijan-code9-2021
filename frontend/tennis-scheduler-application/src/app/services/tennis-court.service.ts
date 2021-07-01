import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TennisCourtService {

  private BACKEND_BASE: string = "http://localhost:8082/api/tennis_courts";

  constructor(private httpClient: HttpClient) { }

  public getAllTennisCourts(): Observable<any> {
    return null;
  }

  public addTennisCourt(): Observable<any> {
    return null;
  }

  public removeTennisCourt(): Observable<any> {
    return null;
  }

}

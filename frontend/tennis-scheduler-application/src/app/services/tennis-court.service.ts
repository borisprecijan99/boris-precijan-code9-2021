import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TennisCourtService {

  private BACKEND_BASE: string = "http://localhost:8082/api/tennis_courts";

  constructor(private httpClient: HttpClient) { }

  getAllTennisCourts(): Observable<any> {
    return null;
  }

  addTennisCourt(): Observable<boolean> {
    return null;
  }

  removeTennisCourt(): Observable<boolean> {
    return null;
  }

}

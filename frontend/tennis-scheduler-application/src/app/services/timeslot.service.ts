import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TimeslotService {

  private BACKEND_BASE: string = "http://localhost:8083/api/timeslots";

  constructor(private httpClient: HttpClient) { }

  public getAllTimeslots(): Observable<any> {
    return null;
  }

  public addTimeslot(): Observable<any> {
    return null;
  }

  public removeTimeslot(): Observable<any> {
    return null;
  }

}

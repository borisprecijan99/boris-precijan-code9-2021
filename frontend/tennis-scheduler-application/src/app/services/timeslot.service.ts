import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Timeslot} from "../shared/model/timeslot";

@Injectable({
  providedIn: 'root'
})
export class TimeslotService {

  private BACKEND_BASE: string = "http://localhost:8083/api/timeslots";

  constructor(private httpClient: HttpClient) { }

  getAllTimeslots(): Observable<Timeslot[]> {
    return this.httpClient.get<Timeslot[]>(this.BACKEND_BASE + "/getAll");
  }

  addTimeslot(timeslot: Timeslot): Observable<boolean> {
    return this.httpClient.post<boolean>(this.BACKEND_BASE + "/add", timeslot);
  }

  removeTimeslot(timeslot: Timeslot): Observable<boolean> {
    return this.httpClient.delete<boolean>(this.BACKEND_BASE + "/remove/" + timeslot.id);
  }

}

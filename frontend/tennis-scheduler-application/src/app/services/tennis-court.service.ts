import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {TennisCourt} from "../shared/model/tennis-court";

@Injectable({
  providedIn: 'root'
})
export class TennisCourtService {

  private BACKEND_BASE: string = "http://localhost:8082/api/tennis_courts";

  constructor(private httpClient: HttpClient) { }

  getAllTennisCourts(): Observable<TennisCourt[]> {
    return this.httpClient.get<TennisCourt[]>(this.BACKEND_BASE + "/getAll");
  }

  addTennisCourt(tennisCourt: TennisCourt): Observable<boolean> {
    return this.httpClient.post<boolean>(this.BACKEND_BASE + "/add", tennisCourt);
  }

  removeTennisCourt(tennisCourt: TennisCourt): Observable<boolean> {
    return this.httpClient.delete<boolean>(this.BACKEND_BASE + "/remove/" + tennisCourt.id);
  }

}

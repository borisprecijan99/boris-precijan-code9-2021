import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class TennisPlayerService {

  private BACKEND_BASE: string = "http://localhost:8081/api/tennis_players";

  constructor(private httpClient: HttpClient) { }

  getAllTennisPlayers(): Observable<Object> {
    return this.httpClient.get(this.BACKEND_BASE + "/getAll");
  }

  addTennisPlayer(): Observable<boolean> {
    return null;
  }

  removeTennisPlayer(): Observable<boolean> {
    return null;
  }

}

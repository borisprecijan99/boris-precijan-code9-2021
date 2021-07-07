import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {TennisPlayer} from "../shared/model/tennis-player";

@Injectable({
  providedIn: 'root'
})
export class TennisPlayerService {

  private BACKEND_BASE: string = "http://localhost:8081/api/tennis_players";

  constructor(private httpClient: HttpClient) { }

  getAllTennisPlayers(): Observable<TennisPlayer[]> {
    return this.httpClient.get<TennisPlayer[]>(this.BACKEND_BASE + "/getAll");
  }

  addTennisPlayer(tennisPlayer: TennisPlayer): Observable<boolean> {
    return this.httpClient.post<boolean>(this.BACKEND_BASE + "/add", tennisPlayer);
  }

  removeTennisPlayer(tennisPlayer: TennisPlayer): Observable<boolean> {
    return this.httpClient.delete<boolean>(this.BACKEND_BASE + "/remove/" + tennisPlayer.id);
  }

}

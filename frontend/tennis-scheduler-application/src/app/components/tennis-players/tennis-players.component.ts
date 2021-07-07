import { Component, OnInit } from '@angular/core';
import {TennisPlayerService} from "../../services/tennis-player.service";
import {TennisPlayer} from "../../shared/model/tennis-player";
import {Observable, Subject} from "rxjs";

@Component({
  selector: 'app-tennis-players',
  templateUrl: './tennis-players.component.html',
  styleUrls: ['./tennis-players.component.css']
})
export class TennisPlayersComponent implements OnInit {

  tennisPlayers: Observable<TennisPlayer[]>;
  isTennisPlayerServiceAvailable: boolean;

  constructor(private tennisPlayerService: TennisPlayerService) { }

  ngOnInit(): void {
    this.tennisPlayers = this.tennisPlayerService.getAllTennisPlayers();
  }

  refreshList(): void {
    this.tennisPlayers = this.tennisPlayerService.getAllTennisPlayers();
  }

  onRemoveTennisPlayer(tennisPlayer: TennisPlayer): void {
    this.tennisPlayerService.removeTennisPlayer(tennisPlayer).subscribe(response => {
      if (response == true) {
        console.log("Tennis player with id=" + tennisPlayer.id + " was successfully removed.");
        this.refreshList();
      } else {

      }
    })
  }

}

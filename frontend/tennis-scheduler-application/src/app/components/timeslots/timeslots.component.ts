import { Component, OnInit } from '@angular/core';
import {TimeslotService} from "../../services/timeslot.service";
import {Timeslot} from "../../shared/model/timeslot";
import {Observable, of} from "rxjs";
import {delay, map, tap, timestamp} from "rxjs/operators";
import {TennisPlayerService} from "../../services/tennis-player.service";
import {TennisPlayer} from "../../shared/model/tennis-player";
import {TennisCourtService} from "../../services/tennis-court.service";
import {TennisCourt} from "../../shared/model/tennis-court";

@Component({
  selector: 'app-timeslots',
  templateUrl: './timeslots.component.html',
  styleUrls: ['./timeslots.component.css']
})
export class TimeslotsComponent implements OnInit {

  timeslots: Observable<Timeslot[]>;
  timeslotsTmp: Timeslot[];
  isTimeslotServiceAvailable: boolean;

  constructor(private timeslotService: TimeslotService, private tennisPlayerService: TennisPlayerService,
              private tennisCourtService: TennisCourtService) { }

  ngOnInit(): void {
    this.timeslotService.getAllTimeslots().subscribe(
      resp => {
        resp.every(ts => {
          ts.tennisPlayer = this.getTennisPlayer(ts.tennisPlayerId);
          ts.tennisCourt = this.getTennisCourt(ts.tennisCourtId);
        });
        this.timeslotsTmp = resp;
      }
    );
  }

  getTennisPlayer(id: number): TennisPlayer {
    let tennisPlayer = null;
    this.tennisPlayerService.getAllTennisPlayers()
      .subscribe(resp => tennisPlayer = resp.find(tp => tp.id = id));
    return tennisPlayer;
  }

  getTennisCourt(id: number): TennisCourt {
    let tennisCourt = null;
    this.tennisCourtService.getAllTennisCourts()
      .subscribe(resp => tennisCourt = resp.find(tc => tc.id = id));
    return tennisCourt;
  }

  refreshList(): void {
    this.timeslots = this.timeslotService.getAllTimeslots();
  }

}

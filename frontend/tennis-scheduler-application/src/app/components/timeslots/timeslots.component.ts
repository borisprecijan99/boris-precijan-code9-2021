import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {TimeslotService} from "../../services/timeslot.service";
import {Timeslot} from "../../shared/model/timeslot";
import {Observable} from "rxjs";
import {TennisPlayerService} from "../../services/tennis-player.service";
import {TennisPlayer} from "../../shared/model/tennis-player";
import {TennisCourtService} from "../../services/tennis-court.service";
import {TennisCourt} from "../../shared/model/tennis-court";

@Component({
  selector: 'app-timeslots',
  templateUrl: './timeslots.component.html',
  styleUrls: ['./timeslots.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class TimeslotsComponent implements OnInit {

  timeslots: Observable<Timeslot[]>;
  tennisPlayers: TennisPlayer[];
  tennisCourts: TennisCourt[];

  constructor(private timeslotService: TimeslotService, private tennisPlayerService: TennisPlayerService,
              private tennisCourtService: TennisCourtService) { }

  ngOnInit(): void {
    this.tennisPlayerService.getAllTennisPlayers().subscribe(resp => {
      this.tennisPlayers = resp;
    });
    this.tennisCourtService.getAllTennisCourts().subscribe(resp => {
      this.tennisCourts = resp;
    });
    this.refreshList();
  }

  onRemoveTimeslot(timeslot: Timeslot): void {
    this.timeslotService.removeTimeslot(timeslot).subscribe(resp => {
      if (resp == true) {
        console.log("Timeslot with id=" + timeslot.id + " successfully removed.");
        this.refreshList();
      } else {
        console.log("Error removing timeslot with id=" + timeslot.id + ".");
      }
    }, error => {
      console.log(error);
    })
  }

  refreshList(): void {
    this.timeslots = this.timeslotService.getAllTimeslots();
  }

  getTennisPlayer(tennisPlayerId: number): string {
    let tennisPlayerString: string;
    let tennisPlayer: TennisPlayer = this.tennisPlayers.find(tp => tp.id == tennisPlayerId);
    tennisPlayerString = tennisPlayer.firstName + " " + tennisPlayer.lastName;
    return tennisPlayerString;
  }

  getTennisCourt(tennisCourtId: number): string {
    let tennisCourtString: string;
    let tennisCourt: TennisCourt = this.tennisCourts.find(tc => tc.id == tennisCourtId);
    tennisCourtString = tennisCourt.name;
    return tennisCourtString;
  }

  isLoggedIn(): boolean {
    if (localStorage.getItem("token"))
      return true;
    return false;
  }

}

import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {TennisPlayerService} from "../../services/tennis-player.service";
import {TennisCourtService} from "../../services/tennis-court.service";
import {TimeslotService} from "../../services/timeslot.service";
import {Observable} from "rxjs";
import {TennisPlayer} from "../../shared/model/tennis-player";
import {TennisCourt} from "../../shared/model/tennis-court";
import {Timeslot} from "../../shared/model/timeslot";

@Component({
  selector: 'app-add-timeslot',
  templateUrl: './add-timeslot.component.html',
  styleUrls: ['./add-timeslot.component.css']
})
export class AddTimeslotComponent implements OnInit {

  newTennisPlayerId: number;
  newTennisCourtId: number;
  duration: number;

  tennisPlayers: Observable<TennisPlayer[]>;
  tennisCourts: Observable<TennisCourt[]>

  @Output()
  onAdd: EventEmitter<void> = new EventEmitter<void>();

  constructor(private tennisPlayerService: TennisPlayerService, private tennisCourtService: TennisCourtService,
              private timeslotService: TimeslotService) { }

  ngOnInit(): void {
    this.duration = 30;
    this.tennisPlayers = this.tennisPlayerService.getAllTennisPlayers();
    this.tennisCourts = this.tennisCourtService.getAllTennisCourts();
  }

  onAddTimeslot(form): void {
    let timeslot: Timeslot = form.value;
    this.timeslotService.addTimeslot(timeslot).subscribe(response => {
      if (response == true) {
        console.log("Timeslot added successfully.");
        form.resetForm();
        this.onAdd.emit();
      } else {
        console.log("Error adding timeslot.");
      }
    }, error => {
      console.log("Timeslot service is not available, please try again later!");
    });
  }

  onChangeTennisPlayerId(timeslot: Timeslot): void {
    timeslot.tennisPlayerId = this.newTennisPlayerId;
  }

  onChangeTennisCourtId(timeslot: Timeslot): void {
    timeslot.tennisCourtId = this.newTennisCourtId;
  }

}

import { Component, OnInit } from '@angular/core';
import {TennisCourtService} from "../../services/tennis-court.service";
import {TennisCourt} from "../../shared/model/tennis-court";
import {Observable} from "rxjs";

@Component({
  selector: 'app-tennis-courts',
  templateUrl: './tennis-courts.component.html',
  styleUrls: ['./tennis-courts.component.css']
})
export class TennisCourtsComponent implements OnInit {

  tennisCourts: Observable<TennisCourt[]>;
  isTennisCourtServiceAvailable: boolean;

  constructor(private tennisCourtService: TennisCourtService) { }

  ngOnInit(): void {
    this.tennisCourts = this.tennisCourtService.getAllTennisCourts();
  }

  refreshList(): void {
    this.tennisCourts = this.tennisCourtService.getAllTennisCourts();
  }

  onRemoveTennisCourt(tennisCourt: TennisCourt): void {
    this.tennisCourtService.removeTennisCourt(tennisCourt).subscribe(response => {
      if (response == true) {
        console.log("Tennis court with id=" + tennisCourt.id + " was successfully removed.");
        this.refreshList();
      } else {

      }
    })
  }

  isLoggedIn(): boolean {
    if (localStorage.getItem("token"))
      return true;
    return false;
  }

}

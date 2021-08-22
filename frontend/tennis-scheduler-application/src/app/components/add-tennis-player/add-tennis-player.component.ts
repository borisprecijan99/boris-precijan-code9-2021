import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {TennisPlayer} from "../../shared/model/tennis-player";
import {TennisPlayerService} from "../../services/tennis-player.service";

@Component({
  selector: 'app-add-tennis-player',
  templateUrl: './add-tennis-player.component.html',
  styleUrls: ['./add-tennis-player.component.css']
})
export class AddTennisPlayerComponent implements OnInit {

  @Output()
  onAdd: EventEmitter<void> = new EventEmitter();

  constructor(private tennisPlayerService: TennisPlayerService) { }

  ngOnInit(): void {
  }

  onAddTennisPlayer(tennisPlayer: TennisPlayer): void {
    this.tennisPlayerService.addTennisPlayer(tennisPlayer).subscribe(response => {
      if (response == true) {
        console.log("Tennis player added successfully.");
        this.onAdd.emit();
      } else {
        console.log("Error adding tennis player.");
      }
    }, error => {
      console.log("Tennis player service is not available, please try again later!");
    });
  }

}

import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {TennisCourtService} from "../../services/tennis-court.service";
import {TennisCourt} from "../../shared/model/tennis-court";

@Component({
  selector: 'app-add-tennis-court',
  templateUrl: './add-tennis-court.component.html',
  styleUrls: ['./add-tennis-court.component.css']
})
export class AddTennisCourtComponent implements OnInit {

  @Output()
  onAdd: EventEmitter<void> = new EventEmitter();

  constructor(private tennisCourtService: TennisCourtService) { }

  ngOnInit(): void {
  }

  onAddTennisCourt(form): void {
    let tennisCourt: TennisCourt = form.value;
    this.tennisCourtService.addTennisCourt(tennisCourt).subscribe(response => {
      if (response == true) {
        console.log("Tennis court added successfully.");
        form.resetForm();
        this.onAdd.emit();
      } else {
        console.log("Error adding tennis court.");
      }
    }, error => {
      console.log("Tennis court service is not available, please try again later!");
    });
  }

}

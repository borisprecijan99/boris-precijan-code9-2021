import {Time} from "@angular/common";
import {TennisPlayer} from "./tennis-player";
import {TennisCourt} from "./tennis-court";

export class Timeslot {
  id: number;
  tennisPlayerId: number;
  tennisCourtId: number;
  dateOfReservation: Date;
  duration: number;
  timeOfReservation: Time;
  tennisPlayer?: TennisPlayer;
  tennisCourt?: TennisCourt;
}

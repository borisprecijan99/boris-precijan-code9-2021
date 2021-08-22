package code9.project.timeslotservice.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeslotDto {

    private int tennisPlayerId;
    private int tennisCourtId;
    private LocalDate dateOfReservation;
    private int duration;
    private LocalTime timeOfReservation;
    private int id;

    public int getTennisPlayerId() {
        return tennisPlayerId;
    }

    public void setTennisPlayerId(int tennisPlayerId) {
        this.tennisPlayerId = tennisPlayerId;
    }

    public int getTennisCourtId() {
        return tennisCourtId;
    }

    public void setTennisCourtId(int tennisCourtId) {
        this.tennisCourtId = tennisCourtId;
    }

    public LocalDate getDateOfReservation() {
        return dateOfReservation;
    }

    public void setDateOfReservation(LocalDate dateOfReservation) {
        this.dateOfReservation = dateOfReservation;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalTime getTimeOfReservation() {
        return timeOfReservation;
    }

    public void setTimeOfReservation(LocalTime timeOfReservation) {
        this.timeOfReservation = timeOfReservation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

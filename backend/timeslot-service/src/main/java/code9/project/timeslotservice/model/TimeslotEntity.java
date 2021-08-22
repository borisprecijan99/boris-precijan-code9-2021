package code9.project.timeslotservice.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "timeslot", schema = "timeslots")
public class TimeslotEntity {

    private int tennisPlayerId;
    private int tennisCourtId;
    private LocalDate dateOfReservation;
    private int duration;
    private LocalTime timeOfReservation;
    private int id;

    @Basic
    @Column(name = "tennis_player_id")
    public int getTennisPlayerId() {
        return tennisPlayerId;
    }

    public void setTennisPlayerId(int tennisPlayerId) {
        this.tennisPlayerId = tennisPlayerId;
    }

    @Basic
    @Column(name = "tennis_court_id")
    public int getTennisCourtId() {
        return tennisCourtId;
    }

    public void setTennisCourtId(int tennisCourtId) {
        this.tennisCourtId = tennisCourtId;
    }

    @Basic
    @Column(name = "date_of_reservation")
    public LocalDate getDateOfReservation() {
        return dateOfReservation;
    }

    public void setDateOfReservation(LocalDate dateOfReservation) {
        this.dateOfReservation = dateOfReservation;
    }

    @Basic
    @Column(name = "duration")
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "time_of_reservation")
    public LocalTime getTimeOfReservation() {
        return timeOfReservation;
    }

    public void setTimeOfReservation(LocalTime timeOfReservation) {
        this.timeOfReservation = timeOfReservation;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeslotEntity that = (TimeslotEntity) o;

        if (tennisPlayerId != that.tennisPlayerId) return false;
        if (tennisCourtId != that.tennisCourtId) return false;
        if (duration != that.duration) return false;
        if (id != that.id) return false;
        if (dateOfReservation != null ? !dateOfReservation.equals(that.dateOfReservation) : that.dateOfReservation != null)
            return false;
        if (timeOfReservation != null ? !timeOfReservation.equals(that.timeOfReservation) : that.timeOfReservation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tennisPlayerId;
        result = 31 * result + tennisCourtId;
        result = 31 * result + (dateOfReservation != null ? dateOfReservation.hashCode() : 0);
        result = 31 * result + duration;
        result = 31 * result + (timeOfReservation != null ? timeOfReservation.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }

}

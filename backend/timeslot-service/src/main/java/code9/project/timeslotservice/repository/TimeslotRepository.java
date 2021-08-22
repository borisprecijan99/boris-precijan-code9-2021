package code9.project.timeslotservice.repository;

import code9.project.timeslotservice.model.TimeslotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TimeslotRepository extends JpaRepository<TimeslotEntity, Integer> {

    int countTimeslotEntityByTennisPlayerId(int tennisPlayerId);
    List<TimeslotEntity> findAllByDateOfReservationAndTennisCourtId(LocalDate dateOfReservation, int tennisCourtId);

}

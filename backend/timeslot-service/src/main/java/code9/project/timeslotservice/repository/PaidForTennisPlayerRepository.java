package code9.project.timeslotservice.repository;

import code9.project.timeslotservice.model.PaidForTennisPlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaidForTennisPlayerRepository extends JpaRepository<PaidForTennisPlayerEntity, Integer> {

}

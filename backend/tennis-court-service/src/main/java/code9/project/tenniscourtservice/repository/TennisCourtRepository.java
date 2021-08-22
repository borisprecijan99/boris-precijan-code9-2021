package code9.project.tenniscourtservice.repository;

import code9.project.tenniscourtservice.model.TennisCourtEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TennisCourtRepository extends JpaRepository<TennisCourtEntity, Integer> {

    List<TennisCourtEntity> findAllByOrderByName();

}

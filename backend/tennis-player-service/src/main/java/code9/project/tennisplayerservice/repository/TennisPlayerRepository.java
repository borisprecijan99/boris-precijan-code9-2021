package code9.project.tennisplayerservice.repository;

import code9.project.tennisplayerservice.model.TennisPlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TennisPlayerRepository extends JpaRepository<TennisPlayerEntity, Integer> {
    List<TennisPlayerEntity> findAllByOrderByLastName();
}

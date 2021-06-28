package code9.project.tennisplayerservice.service;

import code9.project.tennisplayerservice.dto.TennisPlayerDto;
import code9.project.tennisplayerservice.model.TennisPlayerEntity;

import java.util.List;

public interface TennisPlayerService {
    TennisPlayerDto addTennisPlayer(TennisPlayerEntity tennisPlayerEntity);
    boolean removeTennisPlayer(int tennisPlayerId);
    List<TennisPlayerDto> getAllTennisPlayers();
}

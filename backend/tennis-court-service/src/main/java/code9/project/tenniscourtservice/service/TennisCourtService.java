package code9.project.tenniscourtservice.service;

import code9.project.tenniscourtservice.dto.TennisCourtDto;
import code9.project.tenniscourtservice.model.TennisCourtEntity;

import java.util.List;

public interface TennisCourtService {
    boolean addTennisCourt(TennisCourtEntity tennisCourtEntity);
    List<TennisCourtDto> getAllTennisCourts();
    boolean removeTennisCourt(int tennisCourtId);
}

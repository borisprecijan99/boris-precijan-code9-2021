package code9.project.timeslotservice.service;

import code9.project.timeslotservice.dto.TimeslotDto;
import code9.project.timeslotservice.model.PaidForTennisPlayerEntity;
import code9.project.timeslotservice.model.TimeslotEntity;

import java.util.List;

public interface TimeslotService {

    boolean addTimeslot(TimeslotEntity timeslotEntity);
    List<TimeslotDto> getAllTimeslots();
    boolean removeTimeslot(int timeslotId);
    int payForTennisPlayer(PaidForTennisPlayerEntity paidForTennisPlayerEntity);

}

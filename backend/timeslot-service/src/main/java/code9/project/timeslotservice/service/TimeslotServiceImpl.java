package code9.project.timeslotservice.service;

import code9.project.timeslotservice.dto.TimeslotDto;
import code9.project.timeslotservice.mapper.TimeslotMapper;
import code9.project.timeslotservice.model.PaidForTennisPlayerEntity;
import code9.project.timeslotservice.model.TimeslotEntity;
import code9.project.timeslotservice.repository.PaidForTennisPlayerRepository;
import code9.project.timeslotservice.repository.TimeslotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TimeslotServiceImpl implements TimeslotService {

    @Autowired
    private TimeslotRepository timeslotRepository;

    @Autowired
    private TimeslotMapper timeslotMapper;

    @Autowired
    private PaidForTennisPlayerRepository paidForTennisPlayerRepository;

    @Override
    public boolean addTimeslot(TimeslotEntity timeslotEntity) {
        try {
            boolean isOk = timeslotRepository.findAllByDateOfReservationAndTennisCourtId(timeslotEntity.getDateOfReservation(), timeslotEntity.getTennisCourtId()).stream()
                    .allMatch(ts -> {
                        LocalDateTime tsStart = LocalDateTime.of(ts.getDateOfReservation(), ts.getTimeOfReservation());
                        LocalDateTime tsEnd = tsStart.plusMinutes(ts.getDuration());
                        LocalDateTime tsEntityStart = LocalDateTime.of(timeslotEntity.getDateOfReservation(), timeslotEntity.getTimeOfReservation());
                        LocalDateTime tsEntityEnd = tsEntityStart.plusMinutes(timeslotEntity.getDuration());
                        return tsEntityStart.isBefore(tsStart) && tsEntityEnd.isBefore(tsStart) || (tsEntityStart.isAfter(tsEnd) && tsEntityEnd.isAfter(tsEnd));
                    });
            if (!isOk) {
                return false;
            }
            timeslotRepository.save(timeslotEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isTimeToPay(int tennisPlayerId) {
        return timeslotRepository.countTimeslotEntityByTennisPlayerId(tennisPlayerId) == 5;
    }

    @Override
    public int payForTennisPlayer(PaidForTennisPlayerEntity paidForTennisPlayerEntity) {
        try {
            if (isTimeToPay(paidForTennisPlayerEntity.getTennisPlayerId())) {
                paidForTennisPlayerRepository.save(paidForTennisPlayerEntity);
                return 10;
            } else {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public boolean removeTimeslot(int timeslotId) {
        try {
            timeslotRepository.deleteById(timeslotId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<TimeslotDto> getAllTimeslots() {
        return timeslotMapper.toTimeslotDtos(timeslotRepository.findAllByOrderByDateOfReservation());
    }

}

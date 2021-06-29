package code9.project.tenniscourtservice.service;

import code9.project.tenniscourtservice.dto.TimeslotDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "timeslot-service")
public interface TimeslotService {

    @DeleteMapping(value = "api/timeslots/remove/{id}")
    ResponseEntity<Boolean> removeTimeslot(@PathVariable("id") int timeslotId);

    @GetMapping(value = "api/timeslots/getAll")
    ResponseEntity<List<TimeslotDto>> getAllTimeslots();

}

package code9.project.timeslotservice.controller;

import code9.project.timeslotservice.dto.TimeslotDto;
import code9.project.timeslotservice.model.PaidForTennisPlayerEntity;
import code9.project.timeslotservice.model.TimeslotEntity;
import code9.project.timeslotservice.service.AuthService;
import code9.project.timeslotservice.service.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/timeslots")
public class TimeslotController {

    @Autowired
    private AuthService authService;

    @Autowired
    private TimeslotService timeslotService;

    public boolean isLoggedIn() {
        try {
            return authService.isLoggedIn().getBody();
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping(value = "add")
    public ResponseEntity<Boolean> addTimeslot(@RequestBody TimeslotEntity timeslotEntity) {
        return ResponseEntity.ok(timeslotService.addTimeslot(timeslotEntity));
    }

    @PostMapping(value = "payForTennisPlayer")
    public ResponseEntity<Integer> payForTennisPlayer(@RequestBody PaidForTennisPlayerEntity paidForTennisPlayerEntity) {
        int amountOfMoney = timeslotService.payForTennisPlayer(paidForTennisPlayerEntity);
        return ResponseEntity.ok(amountOfMoney);
    }

    @PreAuthorize(value = "@timeslotController.isLoggedIn()")
    @DeleteMapping(value = "remove/{id}")
    public ResponseEntity<Boolean> removeTimeslot(@PathVariable(value = "id") int timeslotId) {
        return ResponseEntity.ok(timeslotService.removeTimeslot(timeslotId));
    }

    @GetMapping(value = "getAll")
    public ResponseEntity<List<TimeslotDto>> getAllTimeslots() {
        return ResponseEntity.ok(timeslotService.getAllTimeslots());
    }

}

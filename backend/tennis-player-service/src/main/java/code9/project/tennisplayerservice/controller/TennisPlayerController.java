package code9.project.tennisplayerservice.controller;

import code9.project.tennisplayerservice.dto.TennisPlayerDto;
import code9.project.tennisplayerservice.model.TennisPlayerEntity;
import code9.project.tennisplayerservice.service.AuthService;
import code9.project.tennisplayerservice.service.TennisPlayerService;
import code9.project.tennisplayerservice.service.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/tennis_players")
public class TennisPlayerController {

    @Autowired
    private TennisPlayerService tennisPlayerService;

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
    public ResponseEntity<Boolean> addTennisPlayer(@RequestBody TennisPlayerEntity tennisPlayerEntity) {
        return ResponseEntity.ok(tennisPlayerService.addTennisPlayer(tennisPlayerEntity));
    }

    @PreAuthorize(value = "@tennisPlayerController.isLoggedIn()")
    @DeleteMapping(value ="remove/{id}")
    public ResponseEntity<Boolean> removeTennisPlayer(@PathVariable("id") int tennisPlayerId) {
        timeslotService.getAllTimeslots().getBody().stream()
                .filter(ts -> ts.getTennisPlayerId() == tennisPlayerId)
                .forEach(ts -> timeslotService.removeTimeslot(ts.getId()));
        return ResponseEntity.ok(tennisPlayerService.removeTennisPlayer(tennisPlayerId));
    }

    @GetMapping(value = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TennisPlayerDto>> getAllTennisPlayers() {
        return ResponseEntity.ok(tennisPlayerService.getAllTennisPlayers());
    }

}

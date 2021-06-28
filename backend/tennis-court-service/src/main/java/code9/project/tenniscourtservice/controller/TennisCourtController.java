package code9.project.tenniscourtservice.controller;

import code9.project.tenniscourtservice.dto.TennisCourtDto;
import code9.project.tenniscourtservice.model.TennisCourtEntity;
import code9.project.tenniscourtservice.service.AuthService;
import code9.project.tenniscourtservice.service.TennisCourtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/tennis_courts")
public class TennisCourtController {

    @Autowired
    private TennisCourtService tennisCourtService;

    @Autowired
    private AuthService authService;

    public boolean isLoggedIn() {
        try {
            return authService.isLoggedIn().getBody();
        } catch (Exception e) {
            return false;
        }
    }

    @PreAuthorize(value = "@tennisCourtController.isLoggedIn()")
    @PostMapping(value = "add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TennisCourtDto> addTennisCourt(@RequestBody TennisCourtEntity tennisCourt) {
        return ResponseEntity.ok(tennisCourtService.addTennisCourt(tennisCourt));
    }

    @GetMapping(value = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TennisCourtDto>> getAllTennisCourts() {
        return ResponseEntity.ok(tennisCourtService.getAllTennisCourts());
    }

    @PreAuthorize(value = "@tennisCourtController.isLoggedIn()")
    @DeleteMapping(value = "remove/{id}")
    public ResponseEntity<Boolean> removeTennisCourt(@PathVariable("id") int tennisCourtId) {
        return ResponseEntity.ok(tennisCourtService.removeTennisCourt(tennisCourtId));
    }

}

package code9.project.timeslotservice.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "tennis-player-service")
public interface TennisPlayerService {

}

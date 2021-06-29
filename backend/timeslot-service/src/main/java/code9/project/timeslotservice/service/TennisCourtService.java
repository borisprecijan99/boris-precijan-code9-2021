package code9.project.timeslotservice.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "tennis-court-service")
public interface TennisCourtService {

}

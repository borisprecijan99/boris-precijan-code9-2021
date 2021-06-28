package code9.project.tenniscourtservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "auth-service")
public interface AuthService {

    @GetMapping(value = "api/users/isLoggedIn")
    ResponseEntity<Boolean> isLoggedIn();

}

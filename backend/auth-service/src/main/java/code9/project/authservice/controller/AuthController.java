package code9.project.authservice.controller;

import code9.project.authservice.model.UserEntity;
import code9.project.authservice.repository.UserRepository;
import code9.project.authservice.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "http://localhost:4200")
@RequestMapping(value = "api/users")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private boolean isLoggedIn;

    @PostMapping(value = "login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
            isLoggedIn = true;
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password!");
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        String jwtToken = jwtTokenUtil.generateToken(userDetails);
        JwtResponse response = new JwtResponse();
        response.setToken(jwtToken);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "register")
    public ResponseEntity<Boolean> register(@RequestBody UserEntity user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.ok(false);
        }
    }

    @GetMapping(value = "isLoggedIn")
    public ResponseEntity<Boolean> isLoggedIn() {
        return ResponseEntity.ok(isLoggedIn);
    }

    @GetMapping(value = "logout")
    public ResponseEntity<Boolean> logout() {
        if (isLoggedIn) {
            isLoggedIn = false;
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.ok(false);
    }

}
